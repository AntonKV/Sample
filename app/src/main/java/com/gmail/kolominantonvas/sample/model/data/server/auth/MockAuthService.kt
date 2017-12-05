package com.gmail.kolominantonvas.sample.model.data.server.auth

import com.gmail.kolominantonvas.sample.entity.pojo.AuthData
import io.reactivex.Single

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
class MockAuthService : AuthService {
    override fun auth(login: String, password: String): Single<AuthData> = Single.create({
        if (login == "Vladimir" && password == "123")
            it.onSuccess(AuthData(1, "Vladimir"))
        else if (login == "Anton" && password == "456")
            it.onSuccess(AuthData(2, "Anton"))
        else
            it.onError(Throwable("User not registered"))
    })
}