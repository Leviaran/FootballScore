package com.example.ran.footballclubv2.common.domain.model

import kotlinx.android.parcel.Parcelize
import java.util.*


data class EventFootball (
        var idEvent : String,
        var strEvent : String,

        var strHomeTeam : String,
        var strAwayTeam : String,

        var intHomeScore : String,
        var intAwayScore : String,

        var intHomeShots : Int,
        var intAwayShots : Int,

        var dateEvent : String,
        var strDate : Date,

        var strHomeGoalDetails : String,
        var strHomeLineupGoalkeeper : String,
        var strHomeLineupDefense : String,
        var strHomeLineupMidfield : String,
        var strHomeLineupForward : String,
        var strHomeLineupSubstitutes : String,
        var strHomeFormation : String,

        var strAwayGoalDetails : String,
        var strAwayLineupGoalkeeper : String,
        var strAwayLineupDefense : String,
        var strAwayLineupMidfield : String,
        var strAwayLineupForward : String,
        var strAwayLineupSubstitutes : String,
        var strAwayFormation : String





)