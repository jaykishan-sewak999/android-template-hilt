package com.android.tempelate.ui.parallelapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.tempelate.model.User
import com.android.tempelate.network.ApiCallHelper
import com.android.tempelate.util.APIResult
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ParallelAPICallViewModel(private val apiCallHelper: ApiCallHelper) : ViewModel() {
    val playersList = MutableLiveData<APIResult<List<User>>>()

    init {
        fetchPlayers()
    }

    private fun fetchPlayers() {
        viewModelScope.launch {
            playersList.postValue(APIResult.loading(null,"Loading"))
            try {
                // coroutineScope is added to avoid crash in case error
                coroutineScope {
                    val apiResultCricketer = async {  apiCallHelper.getCricketers() }
                    val apiResultFootballer = async { apiCallHelper.getFootballPlayers() }
                    val apiAllPlayerResult = mutableListOf<User>()
                    apiAllPlayerResult.addAll(apiResultCricketer.await())
                    apiAllPlayerResult.addAll(apiResultFootballer.await())
                    playersList.postValue(APIResult.success(apiAllPlayerResult,"Success"))
                }
            }
            catch (e:Exception){
                playersList.postValue(APIResult.fail(null,e.message))
            }
        }
    }
}