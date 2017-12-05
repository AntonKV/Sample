package com.gmail.kolominantonvas.sample.di.component

import com.gmail.kolominantonvas.sample.App
import com.gmail.kolominantonvas.sample.di.module.AppModule
import com.gmail.kolominantonvas.sample.di.module.NavigationModule
import com.gmail.kolominantonvas.sample.di.module.RetrofitModule
import com.gmail.kolominantonvas.sample.di.module.ServiceModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ServiceModule::class,
    RetrofitModule::class,
    NavigationModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}