package com.example.ran.footballclubv2.common.domain.interactor

import com.example.ran.footballclubv2.network.ApiService

interface FootballUseCase {
    fun getFootBallResponse() : ApiService
}