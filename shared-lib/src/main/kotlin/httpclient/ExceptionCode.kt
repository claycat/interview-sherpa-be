package com.sherpa.httpclient

interface ExceptionCode {
    fun name(): String

    fun getHttpStatus(): Int

    fun getMessage(): String
}
