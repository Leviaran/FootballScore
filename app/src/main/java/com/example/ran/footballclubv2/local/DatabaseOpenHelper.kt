package com.example.ran.footballclubv2.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

const val DATABASE_NAME = "FavoriteTeam.db"
class DatabaseOpenHelper(context: Context)
    : ManagedSQLiteOpenHelper(context, DATABASE_NAME, null,1) {

    companion object {
        private var instance : DatabaseOpenHelper? = null

        @Synchronized
        fun getInstances(context: Context) : DatabaseOpenHelper {
            when {
                instance == null -> {
                    instance = DatabaseOpenHelper(context)
                    return instance as DatabaseOpenHelper
                }
                else -> {
                    return instance as DatabaseOpenHelper
                }
            }
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        //create table
        db?.createTable(Favorite.TABLE_FAVORITE, true,
                Favorite.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                Favorite.ID_EVENT to TEXT + UNIQUE,
                Favorite.HOME_TEAM to TEXT,
                Favorite.AWAY_TEAM to TEXT,
                Favorite.HOME_SCORE to TEXT,
                Favorite.AWAY_SCORE to TEXT,
                Favorite.HOME_SHOT to TEXT,
                Favorite.AWAY_SHOT to TEXT,
                Favorite.DATE_EVENT to TEXT,
                Favorite.HOME_GOAL_DETAIL to TEXT,
                Favorite.HOME_LINEUP_GOALKEEPER to TEXT,
                Favorite.HOME_LINEUP_DEFENCE to TEXT,
                Favorite.HOME_LINEUP_MIDFIELD to TEXT,
                Favorite.HOME_LINEUP_FORWARD to TEXT,
                Favorite.HOME_LINEUP_SUBTITUTIES to TEXT,
                Favorite.HOME_FORMATION to TEXT,
                Favorite.HOME_BADGE to TEXT,
                Favorite.AWAY_GOAL_DETAIL to TEXT,
                Favorite.AWAY_LINEUP_GOALKEEPER to TEXT,
                Favorite.AWAY_LINEUP_DEFENCE to TEXT,
                Favorite.AWAY_LINEUP_MIDFIELD to TEXT,
                Favorite.AWAY_LINEUP_FORWARD to TEXT,
                Favorite.AWAY_LINEUP_SUBTITUTIES to TEXT,
                Favorite.AWAY_FORMATION to TEXT,
                Favorite.AWAY_BADGE to TEXT
                )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(Favorite.TABLE_FAVORITE, true)
    }

}

// Access property for Context
val Context.database: DatabaseOpenHelper
    get() = DatabaseOpenHelper.getInstances(applicationContext)