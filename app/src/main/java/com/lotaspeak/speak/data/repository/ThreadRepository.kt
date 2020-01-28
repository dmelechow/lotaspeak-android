package com.lotaspeak.speak.data.repository

import com.lotaspeak.speak.data.model.base.BaseResponse
import com.lotaspeak.speak.data.network.RestApi
import io.reactivex.Single
import com.lotaspeak.speak.data.model.Thread


class ThreadRepository(
    private val restApi: RestApi
): IThreadRepository {

    var threadsItems: List<Thread>? = null

    override fun fetchThreads(): Single<BaseResponse<ThreadsData>> {
        return if(threadsItems == null) {
            restApi.fetchTreads()
        } else {
            Single.just(BaseResponse(ThreadsData(threadsItems)))
        }
    }

    override fun setThreads(threadsItems: List<Thread>) {
        this.threadsItems = threadsItems
    }
}

class ThreadsData(var threads: List<Thread>? = null)