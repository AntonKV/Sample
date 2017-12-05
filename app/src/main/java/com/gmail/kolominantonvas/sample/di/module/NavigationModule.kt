package com.gmail.kolominantonvas.sample.di.module

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
@Module
class NavigationModule {
    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    internal fun provideRouter() = cicerone.router

    @Provides
    @Singleton
    internal fun provideNavigatorHolder() = cicerone.navigatorHolder
}