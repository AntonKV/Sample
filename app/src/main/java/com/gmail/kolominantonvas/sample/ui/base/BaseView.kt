package com.gmail.kolominantonvas.sample.ui.base

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
interface BaseView : MvpView {
    @StateStrategyType(SkipStrategy::class)
    fun showToast(message: String)
}