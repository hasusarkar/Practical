package com.practical.viewmodel

class ThrowError(throwError: Throwable?, mLoad: Boolean, mName: String) {
    var throwable: Throwable? = null
    var isLodaer = false
    var apiName: String

    init {
        this.throwable = throwError
        this.isLodaer = mLoad
        this.apiName = mName
    }
}