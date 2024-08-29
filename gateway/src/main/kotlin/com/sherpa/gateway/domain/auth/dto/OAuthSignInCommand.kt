package com.sherpa.gateway.domain.auth.dto

import com.sherpa.gateway.domain.auth.oauthattributes.OAuthAttributes

data class OAuthSignInCommand(
    val attributes: OAuthAttributes
) {
}