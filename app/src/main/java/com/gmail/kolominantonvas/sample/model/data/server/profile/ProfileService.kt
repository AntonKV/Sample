package com.gmail.kolominantonvas.sample.model.data.server.profile

import com.gmail.kolominantonvas.sample.entity.pojo.ProfileData
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

/**
 * Created by Anton Kolomin on 28-Nov-17.
 */
interface ProfileService {
    companion object {
        private const val PROFILE_PATH = "profile"
    }

    @FormUrlEncoded
    @GET("$PROFILE_PATH/login")
    fun getProfile(
            @Field("id") userId: Int
    ): Single<ProfileData>
}