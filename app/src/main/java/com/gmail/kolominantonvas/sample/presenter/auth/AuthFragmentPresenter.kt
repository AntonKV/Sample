package com.gmail.kolominantonvas.sample.presenter.auth

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.gmail.kolominantonvas.sample.entity.constant.Screens
import com.gmail.kolominantonvas.sample.model.interactor.auth.AuthInteractor
import com.gmail.kolominantonvas.sample.ui.auth.AuthFragmentView
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
@InjectViewState
class AuthFragmentPresenter @Inject constructor(
        private val authInteractor: AuthInteractor,
        private val router: Router
) : MvpPresenter<AuthFragmentView>() {

    fun login(login: String, password: String) {
        authInteractor.login(login, password).subscribe({
            router.newRootScreen(Screens.MAIN_SCREEN, it)
        }, {
            viewState.showErrorDialog(login, it.message.toString())
            Timber.e(it)
        })
    }

    fun onBackPressed() = router.exit()
}