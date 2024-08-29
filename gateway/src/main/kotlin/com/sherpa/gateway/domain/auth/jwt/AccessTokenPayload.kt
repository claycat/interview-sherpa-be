package com.sherpa.gateway.domain.auth.jwt

import java.util.*

data class AccessTokenPayload(
    val email: String,
    val issuedAt: Date
) {
}