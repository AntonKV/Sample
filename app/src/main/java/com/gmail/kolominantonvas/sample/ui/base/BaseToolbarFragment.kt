package com.gmail.kolominantonvas.sample.ui.base

import android.util.TypedValue
import com.gmail.kolominantonvas.sample.R
import com.gmail.kolominantonvas.sample.entity.annotation.Toolbar
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 * Created by victor on 29.11.2017.
 */
abstract class BaseToolbarFragment: BaseFragment() {

    override fun initToolbar(toolbarAnnotation: Toolbar) {
        if (toolbarAnnotation.back) {
            val typedValue = TypedValue()
            val theme = context!!.theme
            theme.resolveAttribute(R.attr.homeAsUpIndicator, typedValue, true)

            toolbar.setNavigationIcon(typedValue.resourceId)
            toolbar.setNavigationOnClickListener { onBackPressed() }
        }
        if (toolbarAnnotation.title > 0) {
            toolbar.setTitle(toolbarAnnotation.title)
        }
        if (toolbarAnnotation.subtitle > 0) {
            toolbar.setSubtitle(toolbarAnnotation.subtitle)
        }
    }
}