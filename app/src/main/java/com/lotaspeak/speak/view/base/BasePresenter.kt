package com.lotaspeak.speak.view.base

import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<T : BaseView> : Presenter<T> {

    var view: T? = null
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onAttach(view: T) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
        compositeDisposable.dispose()
    }
}