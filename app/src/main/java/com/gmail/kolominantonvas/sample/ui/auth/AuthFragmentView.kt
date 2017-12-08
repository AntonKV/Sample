package com.gmail.kolominantonvas.sample.ui.auth

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.gmail.kolominantonvas.sample.ui.base.BaseView

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
interface AuthFragmentView : BaseView {
    @StateStrategyType(SkipStrategy::class)
    fun showErrorDialog(login: String, error: String)
}