package com.gmail.kolominantonvas.sample.presenter.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.gmail.kolominantonvas.sample.ui.main.MainFragmentView
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by Anton Kolomin on 30-Nov-17.
 */
@InjectViewState
class MainFragmentPresenter @Inject constructor(
        private val router: Router
) : MvpPresenter<MainFragmentView>() {

    fun onBackPressed() = router.exit()

}