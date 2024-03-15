package com.android.tempelate.ui.parallelapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.tempelate.model.User
import com.android.tempelate.network.ApiCallHelper
import com.android.tempelate.network.ApiService
import com.android.tempelate.util.APIResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ParallelAPICallViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {
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
                    val apiResultCricketer = async {  apiService.getCricketers() }
                    val apiResultFootballer = async { apiService.getFootballPlayers() }
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