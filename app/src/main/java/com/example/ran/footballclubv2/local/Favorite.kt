package com.example.ran.footballclubv2.local

import com.squareup.moshi.Json

data class Favorite(
        val idEvent : String?,
        val strEvent : String?,

        val strHomeTeam : String?,
        val strAwayTeam : String?,

        val intHomeScore : String?,
        val intAwayScore : String?,

        val intHomeShots : Int?,
        val intAwayShots : Int?,

        val dateEvent : String?,
        val strDate : String?,

        val strHomeGoalDetails : String?,
        val strHomeLineupGoalkeeper : String?,
        val strHomeLineupDefense : String?,
        val strHomeLineupMidfield : String?,
        val strHomeLineupForward : String?,
        val strHomeLineupSubstitutes : String?,
        val strHomeFormation : String?,

        val strAwayGoalDetails : String?,
        val strAwayLineupGoalkeeper : String?,
        val strAwayLineupDefense : String?,
        val strAwayLineupMidfield : String?,
        val strAwayLineupForward : String?,
        val strAwayLineupSubstitutes : String?,
        val strAwayFormation : String?,

        var strTeamHomeBadge : String,
        var strTeamAwayBadge : String

){
    companion object {
        const val TABLE_FAVORITE: String = "TABLE_FAVORITE"
        const val ID: String = "ID_"
        const val ID_EVENT : String = "ID_EVENT"
//        const val EVENT : String = "EVENT"

        const val HOME_TEAM : String = "HOME_TEAM"
        const val AWAY_TEAM : String = "AWAY_TEAM"

        const val HOME_SCORE : String = "HOME_SCORE"
        const val AWAY_SCORE : String = "AWAY_SCORE"

        const val HOME_SHOT : String = "HOME_SHOT"
        const val AWAY_SHOT : String = "AWAY_SHOT"

        const val DATE_EVENT : String = "DATE_EVENT"
        const val DATE : String = "DATE"

        const val HOME_GOAL_DETAIL : String = "HOME_GOAL_DETAIL"
        const val HOME_LINEUP_GOALKEEPER : String  = "HOME_LINEUP_GOALKEEPER"
        const val HOME_LINEUP_DEFENCE : String = "HOME_LINEUP_DEFENCE"
        const val HOME_LINEUP_MIDFIELD : String = "HOME_LINEUP_MIDFIELD"
        const val HOME_LINEUP_FORWARD : String = "HOME_LINEUP_FORWARD"
        const val HOME_LINEUP_SUBTITUTIES : String = "HOME_LINEUP_SUBTITUTIES"
        const val HOME_FORMATION : String = "HOME_FORMATION"

        const val AWAY_GOAL_DETAIL : String = "AWAY_GOAL_DETAIL"
        const val AWAY_LINEUP_GOALKEEPER : String = "AWAY_LINEUP_GOALKEEPER"
        const val AWAY_LINEUP_DEFENCE : String = "AWAY_LINEUP_DEFENCE"
        const val AWAY_LINEUP_MIDFIELD : String = "AWAY_LINEUP_MIDFIELD"
        const val AWAY_LINEUP_FORWARD : String= "AWAY_LINEUP_FORWARD"
        const val AWAY_LINEUP_SUBTITUTIES : String= "AWAY_LINEUP_SUBTITUTIES"
        const val AWAY_FORMATION : String = "AWAY_FORMATION"

        const val HOME_BADGE : String = "HOME_BADGE"
        const val AWAY_BADGE : String = "AWAY_BADGE"
    }
}