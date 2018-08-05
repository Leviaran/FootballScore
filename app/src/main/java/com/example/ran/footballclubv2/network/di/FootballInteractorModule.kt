package com.example.ran.footballclubv2.network.di

import com.example.ran.footballclubv2.common.domain.model.LoadFootballDownloader
import com.example.ran.footballclubv2.common.domain.model.LoadFootballRepository
import com.example.ran.footballclubv2.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FootballInteractorModule {

    @Singleton
    @Provides
    fun provideFootballInteractor(apiService: ApiService) : LoadFootballRepository = LoadFootballDownloader(apiService)
}