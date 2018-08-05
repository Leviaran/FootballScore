package com.example.ran.footballclubv2

import android.app.Application
import com.example.ran.footballclubv2.network.di.DaggerNetworkComponent
import com.example.ran.footballclubv2.network.di.NetworkModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DaggerNetworkComponent
                .builder()
                .build()
                .inject(this)

    }
}