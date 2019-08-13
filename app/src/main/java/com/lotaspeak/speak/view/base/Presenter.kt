package com.lotaspeak.speak.view.base

interface Presenter<V : BaseView> {

    fun onAttach(view: V)

    fun onDetach()

}