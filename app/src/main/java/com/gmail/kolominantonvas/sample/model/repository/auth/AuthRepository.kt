package com.gmail.kolominantonvas.sample.model.repository.auth

import com.gmail.kolominantonvas.sample.entity.pojo.AuthData
import com.gmail.kolominantonvas.sample.model.data.auth.AuthHolder
import com.gmail.kolominantonvas.sample.model.data.server.auth.AuthService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
class AuthRepository @Inject constructor(
        private val service: AuthService,
        private val authHolder: AuthHolder
) {
    fun login(login: String, password: String): Single<AuthData> = service.auth(login, password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())

    fun cacheUserLoginData(id: Int, name: String) {
        authHolder.id = id
        authHolder.name = name
    }

    fun isUserLogin(): Single<AuthData> = Single.create {
        if (authHolder.id != 0 && authHolder.name != null)
            it.onSuccess(AuthData(authHolder.id, authHolder.name!!))
        else
            it.onError(Exception("User are not login"))
    }
}