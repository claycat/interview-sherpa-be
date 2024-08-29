package com.sherpa.httpclient

open class DefinedException(
    val exceptionCode: ExceptionCode,
    message: String? = null
) : RuntimeException(message) {
    constructor(exceptionCode: ExceptionCode) : this(exceptionCode, null)

}
