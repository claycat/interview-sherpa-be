package com.sherpa.httpclient

class ApiException(
    private val errorResponse: ErrorResponse
) : RuntimeException() {

    fun getFormattedMessage(): String {
        return "[ERROR]: ApiException - ${errorResponse.status} error : [${errorResponse.message}]"
    }
}