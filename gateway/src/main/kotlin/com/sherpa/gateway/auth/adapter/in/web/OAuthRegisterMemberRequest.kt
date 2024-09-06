package com.sherpa.gateway.auth.adapter.`in`.web

data class OAuthRegisterMemberRequest(
    val email: String,
    val name: String,
    val profileURL: String,
)
