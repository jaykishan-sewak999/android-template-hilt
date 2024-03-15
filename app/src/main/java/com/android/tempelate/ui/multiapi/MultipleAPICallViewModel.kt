package com.android.tempelate.ui.multiapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.tempelate.model.User
import com.android.tempelate.network.ApiCallHelper
import com.android.tempelate.util.APIResult
import kotlinx.coroutines.launch

class MultipleAPICallViewModel(private val apiCallHelper: ApiCallHelper) : ViewModel() {
    val playersList = MutableLiveData<APIResult<List<User>>>()

    init {
        fetchPlayers()
    }

    private fun fetchPlayers() {
        viewModelScope.launch {
            playersList.postValue(APIResult.loading(null,"Loading"))
            try {
                val apiResultCricketer = apiCallHelper.getCricketers()
                val apiResultFootballer = apiCallHelper.getFootballPlayers()
                val apiAllPlayerResult = mutableListOf<User>()
                apiAllPlayerResult.addAll(apiResultCricketer)
                apiAllPlayerResult.addAll(apiResultFootballer)
                playersList.postValue(APIResult.success(apiAllPlayerResult,"Success"))
            }
            catch (e:Exception){
                playersList.postValue(APIResult.fail(null,e.message))
            }
        }
    }
}