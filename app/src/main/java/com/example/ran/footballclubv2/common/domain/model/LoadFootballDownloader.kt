package com.example.ran.footballclubv2.common.domain.model

import com.example.ran.footballclubv2.network.ApiService
import javax.inject.Inject

class LoadFootballDownloader @Inject constructor(private val apiService: ApiService) : LoadFootballRepository {
    override fun execute(): ApiService {
        return apiService
    }

}