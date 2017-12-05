package com.gmail.kolominantonvas.sample.di.module

import android.content.Context
import com.gmail.kolominantonvas.sample.App
import com.gmail.kolominantonvas.sample.di.scope.ActivityScope
import com.gmail.kolominantonvas.sample.model.data.auth.AuthHolder
import com.gmail.kolominantonvas.sample.model.data.storage.Prefs
import com.gmail.kolominantonvas.sample.ui.auth.AuthActivity
import com.gmail.kolominantonvas.sample.ui.main.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton


/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
@Module()
abstract class AppModule {
    @Module
    companion object AppModule{
        @JvmStatic
        @Provides
        @Singleton
        fun context(app: App): Context = app.applicationContext
    }

    @ContributesAndroidInjector(modules = [AuthActivityModule::class])
    @ActivityScope
    abstract fun authActivity(): AuthActivity

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    @ActivityScope
    abstract fun mainActivity(): MainActivity

    @Binds
    @Singleton
    abstract fun preference(newsRepository: Prefs): AuthHolder
}