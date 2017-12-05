package com.gmail.kolominantonvas.sample.model.interactor.auth

import com.gmail.kolominantonvas.sample.entity.pojo.AuthData
import com.gmail.kolominantonvas.sample.model.repository.auth.AuthRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
class AuthInteractor @Inject constructor(
        private val authRepository: AuthRepository
) {
    fun login(login: String, password: String): Single<AuthData>
            = authRepository.login(login, password)
            .doOnSuccess {
                authRepository.cacheUserLoginData(it.id, it.name)
            }

    fun isUserLogin() = authRepository.isUserLogin()

}