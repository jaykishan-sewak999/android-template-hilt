package com.android.tempelate.network

import javax.inject.Inject

class APICallHelperImp @Inject constructor(private val apiService: ApiService)  {
     suspend fun getCricketers() = apiService.getCricketers()
     suspend fun getFootballPlayers() = apiService.getFootballPlayers()
}