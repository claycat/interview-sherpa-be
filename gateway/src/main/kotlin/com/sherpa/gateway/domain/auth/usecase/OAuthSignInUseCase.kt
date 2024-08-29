package com.sherpa.gateway.domain.auth.usecase

import com.sherpa.gateway.domain.auth.client.AuthHttpClient
import com.sherpa.gateway.domain.auth.dto.OAuthRegisterMemberRequest
import com.sherpa.gateway.domain.auth.dto.OAuthSignInCommand
import com.sherpa.gateway.domain.auth.dto.OAuthSignInResult
import com.sherpa.gateway.domain.auth.jwt.AccessTokenPayload
import com.sherpa.gateway.domain.auth.jwt.JwtService
import com.sherpa.gateway.domain.auth.oauthattributes.OAuthAttributes
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class OAuthSignInUseCase(
    private val authHttpClient: AuthHttpClient,
    private val jwtService: JwtService
) {

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

    fun createAccessToken(email: String): String {
        val payload = AccessTokenPayload(
            email,
            issuedAt = Date(System.currentTimeMillis())
        )
        return jwtService.createAccessToken(payload)
    }

    suspend fun oAuthSignIn(command: OAuthSignInCommand): OAuthSignInResult {
        val attributes = command.attributes
        sendOAuthRegisterRequest(attributes)
        val accessToken = createAccessToken(attributes.email)

        return OAuthSignInResult(accessToken)
    }


}