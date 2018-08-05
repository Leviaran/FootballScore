package com.example.ran.footballclubv2.network.di

import com.example.ran.footballclubv2.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NetworkModule::class, FootballInteractorModule::class))
interface NetworkComponent {

    fun inject(app : App)

}