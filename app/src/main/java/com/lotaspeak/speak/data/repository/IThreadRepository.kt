package com.lotaspeak.speak.data.repository

import com.lotaspeak.speak.data.model.base.BaseResponse
import io.reactivex.Single


interface IThreadRepository {
    fun fetchThreads(): Single<BaseResponse<ThreadsData>>
}