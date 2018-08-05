package com.example.ran.footballclubv2.common.domain.model

import com.example.ran.footballclubv2.network.ApiService

interface LoadFootballRepository {
    fun execute () : ApiService
}