package com.gmail.kolominantonvas.sample.presenter.profile

import android.os.Bundle
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.gmail.kolominantonvas.sample.entity.constant.Screens
import com.gmail.kolominantonvas.sample.entity.pojo.AuthData
import com.gmail.kolominantonvas.sample.model.interactor.profile.ProfileInteractor
import com.gmail.kolominantonvas.sample.ui.profile.ProfileView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by Anton Kolomin on 28-Nov-17.
 */
@InjectViewState
class ProfilePresenter @Inject constructor(
        private val router: Router,
        private val profileInteractor: ProfileInteractor
) : MvpPresenter<ProfileView>() {
    private var authData: AuthData? = null
    private val compositeDisposable = CompositeDisposable()

    fun onBackPressed() = router.exit()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        authData?.let {
            profileInteractor.getProfile(it).subscribe({
                viewState.showData(it)
            }, {
                viewState.showToast(it.message.toString())
            })
        }
    }

    fun setParams(arguments: Bundle?) {
        if (arguments != null && arguments.containsKey(Screens.PROFILE_SCREEN)) {
            authData = arguments.getParcelable(Screens.PROFILE_SCREEN)
        }
    }

    fun subscribeOnClick(clickListener: PublishSubject<String>) {
        compositeDisposable.add(clickListener.subscribe {
            viewState.showToast(it)
        })
    }

    fun dispose() {
        compositeDisposable.dispose()
    }
}