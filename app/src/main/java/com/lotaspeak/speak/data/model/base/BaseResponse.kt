package com.lotaspeak.speak.data.model.base


open class BaseResponse<T> {

    var error: ErrorResponse? = null

    var data: T? = null

}