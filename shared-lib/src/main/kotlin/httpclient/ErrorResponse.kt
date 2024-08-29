package com.sherpa.httpclient

data class ErrorResponse(
    val message: String,
    val code: String,
    val status: Int,
)
