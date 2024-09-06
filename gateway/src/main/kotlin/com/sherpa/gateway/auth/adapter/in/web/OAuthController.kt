package com.sherpa.gateway.auth.adapter.`in`.web

import com.sherpa.gateway.auth.application.port.`in`.OAuthSignInUseCase
import com.sherpa.gateway.auth.application.port.`in`.dto.OAuthSignInCommand
import com.sherpa.gateway.auth.application.service.OAuthAttributes
import com.sherpa.gateway.auth.application.service.OAuthProvider
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ServerWebExchange
import java.net.URI

@RestController
class OAuthController(
    private val oAuthSignInUseCase: OAuthSignInUseCase
) {

    @Value("\${service.client}")
    lateinit var clientURL: String

    @GetMapping("/signin/success")
    suspend fun signIn(exchange: ServerWebExchange) {


        val authToken = exchange.getPrincipal<OAuth2AuthenticationToken>().awaitSingle()
        val userAttributes = authToken.principal.attributes
        val oAuthProvider = OAuthProvider.fromValue(authToken.authorizedClientRegistrationId)
        val attributes = OAuthAttributes.of(userAttributes, oAuthProvider)

        val signInResult = oAuthSignInUseCase.oAuthSignIn(OAuthSignInCommand(attributes))
        val accessToken = signInResult.accessToken


        exchange.response.headers.add("Set-Cookie", "accessToken=$accessToken; Path=/; HttpOnly; SameSite=None; Secure")
        exchange.response.statusCode = HttpStatus.FOUND
        exchange.response.headers.location = URI.create(clientURL)
    }
}