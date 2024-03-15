package com.android.tempelate.ui.singleapi

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
class SingleAPICallViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {
     val cricketersList = MutableLiveData<APIResult<List<User>>>()

    init {
        fetchCricketers()
    }

    private fun fetchCricketers() {
        viewModelScope.launch {
            cricketersList.postValue(APIResult.loading(null,"Loading"))
            try {
                val apiResult = apiService.getCricketers()
                cricketersList.postValue(APIResult.success(apiResult,"Success"))
            }
            catch (e:Exception){
                cricketersList.postValue(APIResult.fail(null,e.message))
            }
        }
    }
}