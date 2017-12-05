package com.gmail.kolominantonvas.sample.di.module

import com.gmail.kolominantonvas.sample.BuildConfig
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
@Module
class RetrofitModule {
    companion object {
        private const val API_VERSION = "v1"
        const val BASE_URL_STAGING = "https://api.google.com/$API_VERSION/"
        const val BASE_URL_PRODUCTION = "https://api.testing.google.com/$API_VERSION/"
        var TIMEOUT = if (BuildConfig.DEBUG) 10 else 30
    }

    @Provides
    @Singleton
    fun getRetrofit(client: OkHttpClient): Retrofit = getBuilder(client).build()

    private fun getBuilder(client: OkHttpClient) = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .baseUrl(if (BuildConfig.DEBUG) {
                    BASE_URL_STAGING
                } else {
                    BASE_URL_PRODUCTION
                })

    @Provides
    @Singleton
    fun getClient(): OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .build()

    private fun getInterceptor(): okhttp3.Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}
