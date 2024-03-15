package com.android.tempelate.network

import com.android.tempelate.model.User
import retrofit2.http.GET

interface ApiCallHelper {
    suspend fun getCricketers(): List<User>
    suspend fun getFootballPlayers(): List<User>
}