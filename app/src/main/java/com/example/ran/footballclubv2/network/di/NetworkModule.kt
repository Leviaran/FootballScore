package com.example.ran.footballclubv2.network.di

import com.example.ran.footballclubv2.network.API_BASE_URL
import com.example.ran.footballclubv2.network.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideApiService (retrofit: Retrofit) : ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .client(okHttpClient)
                .build()

    }

    @Provides
    fun provideOkHttpClient() : OkHttpClient {
        var logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
    }
}