package com.android.tempelate.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.tempelate.network.ApiCallHelper
import com.android.tempelate.ui.multiapi.MultipleAPICallViewModel
import com.android.tempelate.ui.parallelapi.ParallelAPICallViewModel
import com.android.tempelate.ui.singleapi.SingleAPICallViewModel

class ViewModelFactory(private val apiCallHelper: ApiCallHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SingleAPICallViewModel::class.java)) {
            return SingleAPICallViewModel(apiCallHelper) as T
        }
        if (modelClass.isAssignableFrom(MultipleAPICallViewModel::class.java)) {
            return MultipleAPICallViewModel(apiCallHelper) as T
        }
        if (modelClass.isAssignableFrom(ParallelAPICallViewModel::class.java)) {
            return ParallelAPICallViewModel(apiCallHelper) as T
        }
        throw IllegalArgumentException("Unable to construct view model")
    }
}