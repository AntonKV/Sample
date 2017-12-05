package com.gmail.kolominantonvas.sample.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.gmail.kolominantonvas.sample.entity.annotation.Toolbar
import com.gmail.kolominantonvas.sample.extension.inflate
import com.gmail.kolominantonvas.sample.extension.toast
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
abstract class BaseFragment : MvpAppCompatFragment(), HasSupportFragmentInjector, BaseView {
    abstract val layoutRes: Int
    override fun showToast(message: String) = context!!.toast(message)

    @Inject lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = container?.inflate(layoutRes)

    abstract fun onBackPressed()

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = childFragmentInjector

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (javaClass.isAnnotationPresent(Toolbar::class.java)) {
            initToolbar(javaClass.getAnnotation(Toolbar::class.java) as Toolbar)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
            when (item.itemId) {
                android.R.id.home -> { onBackPressed(); true }
                else -> super.onOptionsItemSelected(item)
            }

    protected open fun initToolbar(toolbarAnnotation: Toolbar) {
        val toolbar = (activity as AppCompatActivity).supportActionBar
        toolbar?.let {
            if (toolbarAnnotation.back) {
                setHasOptionsMenu(true)
                it.setDisplayHomeAsUpEnabled(true)
            }
            if (toolbarAnnotation.title > 0) {
                it.setTitle(toolbarAnnotation.title)
            }
            if (toolbarAnnotation.subtitle > 0) {
                it.setSubtitle(toolbarAnnotation.subtitle)
            }
        }
    }
}