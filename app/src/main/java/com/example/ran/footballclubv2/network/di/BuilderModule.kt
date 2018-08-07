package com.example.ran.footballclubv2.network.di

import com.example.ran.footballclubv2.screen.detail_match.DetailMatch
import com.example.ran.footballclubv2.screen.detail_match.di.DetailMatchModule
import com.example.ran.footballclubv2.screen.prev_match.PrevMatchFragment
import com.example.ran.footballclubv2.screen.prev_match.di.PrevMatchModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(PrevMatchModule::class))
    abstract fun bindFootballFragment() : PrevMatchFragment

    @ContributesAndroidInjector(modules = arrayOf(DetailMatchModule::class))
    abstract fun bindDetailFragment() : DetailMatch

}