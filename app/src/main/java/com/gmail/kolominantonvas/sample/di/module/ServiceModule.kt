package com.gmail.kolominantonvas.sample.di.module

import com.gmail.kolominantonvas.sample.BuildConfig
import com.gmail.kolominantonvas.sample.model.data.server.auth.AuthService
import com.gmail.kolominantonvas.sample.model.data.server.auth.MockAuthService
import com.gmail.kolominantonvas.sample.model.data.server.profile.MockProfileService
import com.gmail.kolominantonvas.sample.model.data.server.profile.ProfileService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
@Module
class ServiceModule {
    @Provides
    @Singleton
    fun getAuthService(retrofit: Retrofit): AuthService =
            if (BuildConfig.DEBUG && BuildConfig.BUILD_TYPE == "mock")
                MockAuthService()
            else
                retrofit.create<AuthService>(AuthService::class.java)

    @Provides
    @Singleton
    fun getProfileService(retrofit: Retrofit): ProfileService = if (BuildConfig.DEBUG)
        MockProfileService()
    else
        retrofit.create<ProfileService>(ProfileService::class.java)
}