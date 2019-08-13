package com.lotaspeak.speak.view.threads

import com.lotaspeak.speak.data.repository.ThreadsData
import com.lotaspeak.speak.view.base.BasePresenter
import com.lotaspeak.speak.view.base.BaseView


interface ThreadsContract {

    interface View : BaseView {
        fun showThreads(threadsData: ThreadsData)
    }

    abstract class Presenter : BasePresenter<View>() {
        abstract fun fetchThreads()
    }
}