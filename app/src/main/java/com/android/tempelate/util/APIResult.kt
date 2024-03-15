package com.android.tempelate.util

data class APIResult<out T>(val status: Status, val data: T?, val message:String?){

    companion object {
        fun <T> success(data: T?, msg:String?): APIResult<T>{
            return APIResult(Status.SUCCESS,data, msg)
        }

        fun <T> fail(data: T?, msg:String?): APIResult<T>{
            return APIResult(Status.ERROR,data,msg)
        }

        fun <T> loading(data: T?, msg: String?): APIResult<T>{
            return APIResult(Status.LOADING,null, msg)
        }
    }
}
