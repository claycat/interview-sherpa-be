package com.sherpa.gateway.auth.adapter.out.http

import com.sherpa.gateway.auth.adapter.`in`.web.OAuthRegisterMemberRequest
import com.sherpa.gateway.auth.application.port.out.CreateOAuthMemberPort
import com.sherpa.httpclient.retrieveOrPropagate
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class AuthHttpClient(@Qualifier("authWebClient") private val webClient: WebClient) : CreateOAuthMemberPort {

    override suspend fun postOAuthMember(oAuthRegisterMemberRequest: OAuthRegisterMemberRequest) {
        webClient.post()
            .uri("/member")
            .bodyValue(oAuthRegisterMemberRequest)
            .retrieveOrPropagate()
            .toEntity(Void::class.java)
            .awaitSingle()
    }
}