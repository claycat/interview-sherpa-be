package com.sherpa.gateway.domain.auth.dto

data class OAuthRegisterMemberRequest(
    val email: String,
    val name: String,
    val profileURL: String,
)
