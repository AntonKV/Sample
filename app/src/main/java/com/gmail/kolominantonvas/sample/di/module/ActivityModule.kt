package com.gmail.kolominantonvas.sample.di.module

import com.gmail.kolominantonvas.sample.di.scope.FragmentScope
import com.gmail.kolominantonvas.sample.ui.auth.AuthFragment
import com.gmail.kolominantonvas.sample.ui.main.MainFragment
import com.gmail.kolominantonvas.sample.ui.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
@Module
interface AuthActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [])
    fun authFragment(): AuthFragment
}

@Module
interface MainActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [])
    fun mainFragment(): MainFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [])
    fun profileFragment(): ProfileFragment
}