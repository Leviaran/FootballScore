package com.example.ran.footballclubv2.screen.detail_match.di

import com.example.ran.footballclubv2.common.domain.interactor.FootaballInteractor
import com.example.ran.footballclubv2.screen.detail_match.DetailMatchViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class DetailMatchModule {

    @Provides
    fun provideDetailMatchViewModelFactory
            (footballInteractor: FootaballInteractor) : DetailMatchViewModelFactory {
        return DetailMatchViewModelFactory(footballInteractor)
    }
}