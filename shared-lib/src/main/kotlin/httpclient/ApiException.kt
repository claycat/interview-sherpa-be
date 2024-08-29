package com.sherpa.httpclient

class ApiException(
    val errorResponse: ErrorResponse
) : RuntimeException() {

    fun getFormattedMessage(): String {
        return "[ERROR]: ApiException - ${errorResponse.status} error : [${errorResponse.message}]"
    }
}