package com.lotaspeak.speak.data.repository

import com.lotaspeak.speak.data.model.base.BaseResponse
import com.lotaspeak.speak.data.network.RestApi
import io.reactivex.Single
import com.lotaspeak.speak.data.model.Thread


class ThreadRepository(
    private val restApi: RestApi
): IThreadRepository {

    override fun fetchThreads(): Single<BaseResponse<ThreadsData>> {
        return restApi.fetchTreads()
    }
}

class ThreadsData {
    var threads: List<Thread>? = null
}