package com.lotaspeak.speak.data.network

import com.lotaspeak.speak.data.model.base.BaseResponse
import io.reactivex.Single
import retrofit2.http.GET
import com.lotaspeak.speak.data.model.Thread
import com.lotaspeak.speak.data.repository.ThreadsData


interface RestApi {

    @GET("thread")
    fun fetchTreads(): Single<BaseResponse<ThreadsData>>

    @GET("thread")
    fun fetchThread(): Single<BaseResponse<Thread>>

}