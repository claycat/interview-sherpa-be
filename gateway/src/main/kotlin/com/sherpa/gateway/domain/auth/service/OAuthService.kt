package com.sherpa.gateway.domain.auth.service

import com.sherpa.gateway.domain.auth.client.AuthHttpClient
import com.sherpa.gateway.domain.auth.dto.OAuthRegisterMemberRequest
import com.sherpa.gateway.domain.auth.oauthattributes.OAuthAttributes
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class OAuthService(private val authHttpClient: AuthHttpClient) {
    suspend fun sendOAuthRegisterRequest(attributes: OAuthAttributes): ResponseEntity<Void> {
        val response = authHttpClient.postOAuthMember(
            OAuthRegisterMemberRequest(
                attributes.email,
                attributes.name,
                attributes.profileURL
            )
        )
        return response
    }

}