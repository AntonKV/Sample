package com.gmail.kolominantonvas.sample.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpAppCompatActivity
import com.gmail.kolominantonvas.sample.extension.toast
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.layout_toolbar.*
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
abstract class BaseActivity : MvpAppCompatActivity(), HasFragmentInjector,
        HasSupportFragmentInjector, BaseView {
    abstract val layoutRes: Int
    abstract val navigator: SupportAppNavigator?
    override fun showToast(message: String) = toast(message)

    @Inject lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject lateinit var frameworkFragmentInjector: DispatchingAndroidInjector<android.app.Fragment>
    @Inject lateinit var navigationHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
        setSupportActionBar(toolbar)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = this.supportFragmentInjector

    override fun fragmentInjector(): AndroidInjector<android.app.Fragment>
            = this.frameworkFragmentInjector

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigationHolder.removeNavigator()
        super.onPause()
    }
}