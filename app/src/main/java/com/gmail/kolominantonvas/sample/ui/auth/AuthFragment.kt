package com.gmail.kolominantonvas.sample.ui.auth

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.gmail.kolominantonvas.sample.R
import com.gmail.kolominantonvas.sample.entity.annotation.Toolbar
import com.gmail.kolominantonvas.sample.presenter.auth.AuthFragmentPresenter
import com.gmail.kolominantonvas.sample.ui.base.BaseToolbarFragment
import kotlinx.android.synthetic.main.fragment_auth.*
import javax.inject.Inject

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
@Toolbar(back = false, title = R.string.auth)
class AuthFragment : BaseToolbarFragment(), AuthFragmentView {
    override fun onBackPressed() = presenter.onBackPressed()

    override val layoutRes = R.layout.fragment_auth

    @InjectPresenter
    @Inject lateinit var presenter: AuthFragmentPresenter

    @ProvidePresenter
    fun providePresenter(): AuthFragmentPresenter = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login_btn.setOnClickListener {
            presenter.login(login.text.toString(), password.text.toString())
        }
    }
}