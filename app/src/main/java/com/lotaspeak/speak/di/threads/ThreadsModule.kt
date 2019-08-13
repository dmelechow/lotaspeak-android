package com.lotaspeak.speak.di.threads

import com.lotaspeak.speak.data.network.RestApi
import com.lotaspeak.speak.data.repository.IThreadRepository
import com.lotaspeak.speak.data.repository.ThreadRepository
import com.lotaspeak.speak.di.scopes.ThreadsScope
import com.lotaspeak.speak.view.threads.ThreadsContract
import com.lotaspeak.speak.view.threads.ThreadsPresenter
import dagger.Module
import dagger.Provides


@Module
class ThreadsModule {

    @Provides
    @ThreadsScope
    fun provideRepository(restApi: RestApi): IThreadRepository {
        return ThreadRepository(restApi)
    }

    @Provides
    @ThreadsScope
    fun providePresenter(repository: IThreadRepository): ThreadsContract.Presenter {
        return ThreadsPresenter(repository)
    }
}