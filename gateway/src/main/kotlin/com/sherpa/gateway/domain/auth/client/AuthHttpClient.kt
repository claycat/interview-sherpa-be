package com.sherpa.gateway.domain.auth.client

import com.sherpa.gateway.domain.auth.dto.OAuthRegisterMemberRequest
import com.sherpa.httpclient.retrieveOrPropagate
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class AuthHttpClient(@Qualifier("authWebClient") private val webClient: WebClient) {

    suspend fun postOAuthMember(oAuthRegisterMemberRequest: OAuthRegisterMemberRequest): ResponseEntity<Void> {
        val response = webClient.post()
            .uri("/member")
            .bodyValue(oAuthRegisterMemberRequest)
            .retrieveOrPropagate()
            .toEntity(Void::class.java)
            .awaitSingle()

        return response
    }
}