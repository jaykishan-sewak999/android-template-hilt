package com.android.tempelate.ui.singleapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.tempelate.model.User
import com.android.tempelate.network.ApiCallHelper
import com.android.tempelate.util.APIResult
import kotlinx.coroutines.launch

class SingleAPICallViewModel(private val apiCallHelper: ApiCallHelper) : ViewModel() {
    val cricketersList = MutableLiveData<APIResult<List<User>>>()

    init {
        fetchCricketers()
    }

    private fun fetchCricketers() {
        viewModelScope.launch {
            cricketersList.postValue(APIResult.loading(null,"Loading"))
            try {
                val apiResult = apiCallHelper.getCricketers()
                cricketersList.postValue(APIResult.success(apiResult,"Success"))
            }
            catch (e:Exception){
                cricketersList.postValue(APIResult.fail(null,e.message))
            }
        }
    }
}