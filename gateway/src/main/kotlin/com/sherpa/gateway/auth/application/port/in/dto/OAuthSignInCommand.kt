package com.sherpa.gateway.auth.application.port.`in`.dto

import com.sherpa.gateway.auth.application.service.OAuthAttributes

data class OAuthSignInCommand(
    val attributes: OAuthAttributes
) {
}