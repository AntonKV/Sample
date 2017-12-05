package com.gmail.kolominantonvas.sample.ui.profile

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.gmail.kolominantonvas.sample.R
import com.gmail.kolominantonvas.sample.entity.annotation.Toolbar
import com.gmail.kolominantonvas.sample.entity.pojo.ProfileItemData
import com.gmail.kolominantonvas.sample.presenter.profile.ProfilePresenter
import com.gmail.kolominantonvas.sample.ui.base.BaseFragment
import com.gmail.kolominantonvas.sample.ui.profile.adapter.ProfileAdapter
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
@Toolbar(back = false, title = R.string.list)
class ProfileFragment : BaseFragment(), ProfileView {
    override val layoutRes: Int = R.layout.fragment_list
    override fun onBackPressed() = presenter.onBackPressed()

    @InjectPresenter
    @Inject lateinit var presenter: ProfilePresenter

    @ProvidePresenter
    fun providePresenter(): ProfilePresenter = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.setParams(arguments)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = ProfileAdapter()
        }

        presenter.subscribeOnClick((recycler_view.adapter as ProfileAdapter).clickListener)
    }

    override fun onPause() {
        super.onPause()
        presenter.dispose()
    }

    override fun showData(data: MutableSet<ProfileItemData>) {
        (recycler_view.adapter as ProfileAdapter).setData(data)
    }
}