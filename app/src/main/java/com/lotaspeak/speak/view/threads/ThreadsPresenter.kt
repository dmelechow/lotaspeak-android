package com.lotaspeak.speak.view.threads

import com.lotaspeak.speak.data.model.base.BaseResponse
import com.lotaspeak.speak.data.repository.IThreadRepository
import com.lotaspeak.speak.data.repository.ThreadsData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ThreadsPresenter(
    private val repository: IThreadRepository
) : ThreadsContract.Presenter() {

    override fun fetchThreads() {
        compositeDisposable.add(
            repository.fetchThreads()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result: BaseResponse<ThreadsData> ->
                        if (result.data != null) {
                            view?.showThreadsState(result.data!!)
                        } else {
                            view?.showEmptyState()
                        }
                    },
                    {
                        view?.showErrorState(it.message)
                    }
                )
        )
    }
}