package com.gmail.kolominantonvas.sample.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.gmail.kolominantonvas.sample.R
import com.gmail.kolominantonvas.sample.entity.constant.Screens
import com.gmail.kolominantonvas.sample.entity.pojo.AuthData
import com.gmail.kolominantonvas.sample.extension.getBundleFragment
import com.gmail.kolominantonvas.sample.presenter.main.MainFragmentPresenter
import com.gmail.kolominantonvas.sample.ui.base.BaseFragment
import com.gmail.kolominantonvas.sample.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

/**
 * Created by Anton Kolomin on 30-Nov-17.
 */
class MainFragment : BaseFragment(), MainFragmentView {
    override val layoutRes: Int = R.layout.fragment_main
    override fun onBackPressed() = presenter.onBackPressed()

    private lateinit var tabs: HashMap<String, Fragment>
    private val tabKeys = listOf(
            tabIdToFragmentTag(R.id.tab_count),
            tabIdToFragmentTag(R.id.tab_groups),
            tabIdToFragmentTag(R.id.tab_info)
    )

    @InjectPresenter
    @Inject lateinit var presenter: MainFragmentPresenter

    @ProvidePresenter
    fun providePresenter(): MainFragmentPresenter = presenter

    private fun tabIdToFragmentTag(id: Int) = "tab_$id"

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState == null) {
            var authData: AuthData? = null
            if (arguments != null && arguments!!.containsKey(Screens.MAIN_SCREEN)) {
                authData = arguments!!.getParcelable(Screens.MAIN_SCREEN)
            }
            tabs = createNewFragments(authData)
            childFragmentManager.beginTransaction()
                    .add(R.id.mainScreenContainer, tabs[tabKeys[0]], tabKeys[0])
                    .add(R.id.mainScreenContainer, tabs[tabKeys[1]], tabKeys[1])
                    .add(R.id.mainScreenContainer, tabs[tabKeys[2]], tabKeys[2])
                    .commit()
            bottomBar.selectTabAtPosition(0, false)
        } else {
            tabs = findFragments()
        }

        bottomBar.setOnTabSelectListener { showTab(it) }
    }

    private fun createNewFragments(authData: AuthData?): HashMap<String, Fragment> = hashMapOf(
            tabKeys[0] to ProfileFragment().getBundleFragment(Screens.PROFILE_SCREEN, authData),
            tabKeys[1] to ProfileFragment().getBundleFragment(Screens.PROFILE_SCREEN, authData),
            tabKeys[2] to ProfileFragment().getBundleFragment(Screens.PROFILE_SCREEN, authData)
    )

    private fun findFragments(): HashMap<String, Fragment> = hashMapOf(
            tabKeys[0] to childFragmentManager.findFragmentByTag(tabKeys[0]) as BaseFragment,
            tabKeys[1] to childFragmentManager.findFragmentByTag(tabKeys[1]) as BaseFragment,
            tabKeys[2] to childFragmentManager.findFragmentByTag(tabKeys[2]) as BaseFragment
    )

    private fun showTab(id: Int) = childFragmentManager.beginTransaction()
            .detach(tabs[tabIdToFragmentTag(R.id.tab_count)])
            .detach(tabs[tabIdToFragmentTag(R.id.tab_groups)])
            .detach(tabs[tabIdToFragmentTag(R.id.tab_info)])
            .attach(tabs[tabIdToFragmentTag(id)])
            .commit()
}