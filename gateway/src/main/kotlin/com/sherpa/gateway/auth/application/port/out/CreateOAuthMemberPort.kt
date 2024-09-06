package com.sherpa.gateway.auth.application.port.out

import com.sherpa.gateway.auth.adapter.`in`.web.OAuthRegisterMemberRequest

interface CreateOAuthMemberPort {

    suspend fun postOAuthMember(request: OAuthRegisterMemberRequest)
}