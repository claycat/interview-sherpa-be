package com.sherpa.gateway.auth.application.port.`in`

import com.sherpa.gateway.auth.application.port.`in`.dto.OAuthSignInCommand
import com.sherpa.gateway.auth.application.port.`in`.dto.OAuthSignInResult

interface OAuthSignInUseCase {

    suspend fun oAuthSignIn(command: OAuthSignInCommand): OAuthSignInResult

}