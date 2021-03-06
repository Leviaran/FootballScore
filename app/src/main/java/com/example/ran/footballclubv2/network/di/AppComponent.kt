package com.example.ran.footballclubv2.network.di

import android.app.Application
import com.example.ran.footballclubv2.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton

//@Component(modules = arrayOf(NetworkModule::class,
//        FootballInteractorModule::class,
//        BuilderModule::class,
//        AndroidSupportInjectionModule::class))

@Component(modules = [NetworkModule::class,
    FootballInteractorModule::class,
    BuilderModule::class,
    AndroidSupportInjectionModule::class])
interface AppComponent  {


    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(app: Application) :Builder
        fun build() : AppComponent
    }

    fun inject(app: App)

}