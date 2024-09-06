package com.sherpa.gateway.auth.application.service

import com.sherpa.gateway.auth.adapter.`in`.web.OAuthRegisterMemberRequest
import com.sherpa.gateway.auth.application.port.`in`.OAuthSignInUseCase
import com.sherpa.gateway.auth.application.port.`in`.dto.OAuthSignInCommand
import com.sherpa.gateway.auth.application.port.`in`.dto.OAuthSignInResult
import com.sherpa.gateway.auth.application.port.out.CreateOAuthMemberPort
import com.sherpa.gateway.common.annotation.UseCase


@UseCase
class OAuthSignInService(
    private val createOAuthMemberPort: CreateOAuthMemberPort,
    private val jwtHelper: JwtHelper
) : OAuthSignInUseCase {


    suspend fun createOAuthMember(attributes: OAuthAttributes) {
        createOAuthMemberPort.postOAuthMember(
            OAuthRegisterMemberRequest(
                attributes.email,
                attributes.name,
                attributes.profileURL
            )
        )
    }

    fun createAccessToken(email: String): String {
        return jwtHelper.createJwt(email)
    }

    override suspend fun oAuthSignIn(command: OAuthSignInCommand): OAuthSignInResult {

        val attributes = command.attributes
        createOAuthMember(attributes)
        val accessToken = createAccessToken(attributes.email)

        return OAuthSignInResult(accessToken)

    }
}