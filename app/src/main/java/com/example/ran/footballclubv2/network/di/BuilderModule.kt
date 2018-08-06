package com.example.ran.footballclubv2.network.di

import com.example.ran.footballclubv2.screen.prev_match.PrevMatchFragment
import com.example.ran.footballclubv2.screen.prev_match.di.PrevMatchModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule {
    @ContributesAndroidInjector(modules = arrayOf(PrevMatchModule::class))
    abstract fun bindForeCastActivity() : PrevMatchFragment
}