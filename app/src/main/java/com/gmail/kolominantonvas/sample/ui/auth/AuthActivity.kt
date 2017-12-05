package com.gmail.kolominantonvas.sample.ui.auth

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.gmail.kolominantonvas.sample.R
import com.gmail.kolominantonvas.sample.entity.constant.Screens
import com.gmail.kolominantonvas.sample.presenter.auth.AuthActivityPresenter
import com.gmail.kolominantonvas.sample.ui.base.BaseActivity
import com.gmail.kolominantonvas.sample.ui.main.MainActivity
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */

class AuthActivity : BaseActivity(), AuthActivityView {
    override val layoutRes: Int = R.layout.activity_host_no_toolbar

    @InjectPresenter
    @Inject lateinit var presenter: AuthActivityPresenter

    @ProvidePresenter
    fun providePresenter(): AuthActivityPresenter = presenter

    override val navigator = object : SupportAppNavigator(this, R.id.container) {

        override fun createActivityIntent(screenKey: String?, data: Any?): Intent? = when (screenKey) {
            Screens.MAIN_SCREEN -> {
                val bundle = Bundle()
                bundle.putParcelable(screenKey, data as Parcelable)
                Intent(this@AuthActivity, MainActivity::class.java)
                        .putExtra(screenKey, bundle)
            }
            else -> null
        }

        override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
            Screens.AUTH_SCREEN -> AuthFragment()
            else -> null
        }
    }
}
