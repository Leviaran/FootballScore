package com.example.ran.footballclubv2.common.domain.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import java.util.*


data class EventFootball (
        @Json(name = "events") val events: List<Events>
)
@Parcelize
data class Events (
        @Json(name = "idEvent") val idEvent : String?,
        @Json(name = "strEvent") val strEvent : String?,

        @Json(name = "strHomeTeam") val strHomeTeam : String?,
        @Json(name = "strAwayTeam") val strAwayTeam : String?,

        @Json(name = "intHomeScore") val intHomeScore : String?,
        @Json(name = "intAwayScore")val intAwayScore : String?,

        @Json(name = "intHomeShots") val intHomeShots : Int?,
        @Json(name = "intAwayShots") val intAwayShots : Int?,

        @Json(name = "dateEvent") val dateEvent : String?,
        @Json(name = "strDate") val strDate : String?,

        @Json(name = "strHomeGoalDetails") val strHomeGoalDetails : String?,
        @Json(name = "strHomeLineupGoalkeeper") val strHomeLineupGoalkeeper : String?,
        @Json(name = "strHomeLineupDefense") val strHomeLineupDefense : String?,
        @Json(name = "strHomeLineupMidfield") val strHomeLineupMidfield : String?,
        @Json(name = "strHomeLineupForward") val strHomeLineupForward : String?,
        @Json(name = "strHomeLineupSubstitutes") val strHomeLineupSubstitutes : String?,
        @Json(name = "strHomeFormation") val strHomeFormation : String?,

        @Json(name = "strAwayGoalDetails") val strAwayGoalDetails : String?,
        @Json(name = "strAwayLineupGoalkeeper") val strAwayLineupGoalkeeper : String?,
        @Json(name = "strAwayLineupDefense") val strAwayLineupDefense : String?,
        @Json(name = "strAwayLineupMidfield") val strAwayLineupMidfield : String?,
        @Json(name = "strAwayLineupForward") val strAwayLineupForward : String?,
        @Json(name = "strAwayLineupSubstitutes") val strAwayLineupSubstitutes : String?,
        @Json(name = "strAwayFormation") val strAwayFormation : String?,

        var strTeamHomeBadge : String,
        var strTeamAwayBadge : String



) : Parcelable