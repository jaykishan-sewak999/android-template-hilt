package com.android.tempelate.ui.multiapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.tempelate.model.User
import com.android.tempelate.network.ApiCallHelper
import com.android.tempelate.network.ApiService
import com.android.tempelate.util.APIResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MultipleAPICallViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {
    val playersList = MutableLiveData<APIResult<List<User>>>()

    init {
        fetchPlayers()
    }

    private fun fetchPlayers() {
        viewModelScope.launch {
            playersList.postValue(APIResult.loading(null,"Loading"))
            try {
                val apiResultCricketer = apiService.getCricketers()
                val apiResultFootballer = apiService.getFootballPlayers()
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