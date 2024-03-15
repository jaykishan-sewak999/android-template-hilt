package com.android.tempelate.network

class APICallHelperImp(private val apiService: ApiService) : ApiCallHelper {
    override suspend fun getCricketers() = apiService.getCricketers()
    override suspend fun getFootballPlayers() = apiService.getFootballPlayers()
}