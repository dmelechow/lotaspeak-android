package com.lotaspeak.speak.data.model.base


open class BaseResponse<T>(var data: T? = null) {

    var error: ErrorResponse? = null

}