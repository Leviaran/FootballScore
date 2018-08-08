package com.example.ran.footballclubv2.screen.match.di

import com.example.ran.footballclubv2.common.domain.interactor.FootaballInteractor
import com.example.ran.footballclubv2.screen.match.PrevMatchViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PrevMatchModule {

    @Provides
    fun providePrevMatchViewModelFactory(footaballInteractor: FootaballInteractor) : PrevMatchViewModelFactory {
        return PrevMatchViewModelFactory(footaballInteractor)
    }
}