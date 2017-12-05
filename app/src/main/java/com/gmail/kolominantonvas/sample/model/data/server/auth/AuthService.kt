package com.gmail.kolominantonvas.sample.model.data.server.auth

import com.gmail.kolominantonvas.sample.entity.pojo.AuthData
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
interface AuthService {
    companion object {
        private const val AUTH_PATH = "auth"
    }

    @FormUrlEncoded
    @POST("${AUTH_PATH}/login")
    fun auth(
            @Field("login") login: String,
            @Field("password") password: String
    ): Single<AuthData>
}