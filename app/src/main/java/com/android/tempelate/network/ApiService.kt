package com.android.tempelate.network

import com.android.tempelate.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getCricketers(): List<User>

    @GET("users")
    suspend fun getFootballPlayers(): List<User>
}