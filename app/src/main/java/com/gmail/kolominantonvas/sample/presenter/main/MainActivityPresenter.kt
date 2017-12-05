package com.gmail.kolominantonvas.sample.presenter.main

import android.os.Bundle
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.gmail.kolominantonvas.sample.entity.constant.Screens
import com.gmail.kolominantonvas.sample.entity.pojo.AuthData
import com.gmail.kolominantonvas.sample.ui.main.MainActivityView
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
@InjectViewState
class MainActivityPresenter @Inject constructor(
        private val router: Router
) : MvpPresenter<MainActivityView>() {
    private var authData: AuthData? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.MAIN_SCREEN, authData)
    }

    fun setParams(extras: Bundle?) {
        if (extras != null && extras.containsKey(Screens.MAIN_SCREEN))
            authData = extras.getBundle(Screens.MAIN_SCREEN).getParcelable(Screens.MAIN_SCREEN)
    }
}