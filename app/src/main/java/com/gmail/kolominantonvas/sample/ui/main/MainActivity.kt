package com.gmail.kolominantonvas.sample.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.gmail.kolominantonvas.sample.R
import com.gmail.kolominantonvas.sample.entity.constant.Screens
import com.gmail.kolominantonvas.sample.extension.getBundleFragment
import com.gmail.kolominantonvas.sample.presenter.main.MainActivityPresenter
import com.gmail.kolominantonvas.sample.ui.base.BaseActivity
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
class MainActivity : BaseActivity(), MainActivityView {
    override val layoutRes = R.layout.activity_host

    @InjectPresenter
    @Inject lateinit var presenter: MainActivityPresenter

    @ProvidePresenter
    fun providePresenter(): MainActivityPresenter = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null)
            presenter.setParams(intent.extras)
    }

    override val navigator = object : SupportAppNavigator(this, R.id.container) {

        override fun createActivityIntent(screenKey: String?, data: Any?): Intent? = null

        override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
            Screens.MAIN_SCREEN -> MainFragment().getBundleFragment(screenKey, data)
            else -> null
        }
    }
}