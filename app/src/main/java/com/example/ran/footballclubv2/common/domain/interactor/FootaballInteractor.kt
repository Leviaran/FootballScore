package com.example.ran.footballclubv2.common.domain.interactor

import com.example.ran.footballclubv2.common.domain.model.LoadFootballRepository
import com.example.ran.footballclubv2.network.ApiService
import javax.inject.Inject

class FootaballInteractor @Inject constructor(private val loadFootballRepository: LoadFootballRepository) : FootballUseCase {
    override fun getFootBallResponse(): ApiService {
        return loadFootballRepository.execute()
    }

}