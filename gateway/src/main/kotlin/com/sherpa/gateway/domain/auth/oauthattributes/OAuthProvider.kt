package com.sherpa.gateway.domain.auth.oauthattributes

enum class OAuthProvider(val providerId: String) {
    GOOGLE("google"),
    GITHUB("github");

    companion object {
        fun fromValue(value: String): OAuthProvider {
            return values().find { it.providerId.equals(value, ignoreCase = true) }
                ?: throw IllegalArgumentException("No OAuthProvider available for value: $value")
        }
    }
}