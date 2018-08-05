package com.example.ran.footballclubv2.network

import com.example.ran.footballclubv2.common.domain.model.EventFootball
import com.example.ran.footballclubv2.common.domain.model.TeamDetail
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

const val API_BASE_URL = "https://www.thesportsdb.com/"

// 4328
interface ApiService {
    @GET("/api/v1/json/1/eventspastleague.php")
    fun getFootballEvent(
            @Query("id") id : String
    ) : Single<EventFootball>

    @GET("/api/v1/json/1/searchteams.php")
    fun getTeamData(
            @Query("t") t : String
    ) : Single<TeamDetail>

}