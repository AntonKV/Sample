package com.gmail.kolominantonvas.sample.presenter.auth

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.gmail.kolominantonvas.sample.entity.constant.Screens
import com.gmail.kolominantonvas.sample.model.interactor.auth.AuthInteractor
import com.gmail.kolominantonvas.sample.ui.auth.AuthActivityView
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
@InjectViewState
class AuthActivityPresenter @Inject constructor(
        private val router: Router,
        private val authInteractor: AuthInteractor
) : MvpPresenter<AuthActivityView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        authInteractor.isUserLogin().subscribe({
            router.replaceScreen(Screens.MAIN_SCREEN, it)
        }, {
            router.replaceScreen(Screens.AUTH_SCREEN)
        })
    }
}