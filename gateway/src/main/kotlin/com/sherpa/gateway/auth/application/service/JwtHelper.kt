package com.sherpa.gateway.auth.application.service

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtHelper(
    @Value("\${jwt.secret-key}")
    secretKeyBase64: String
) {
    private val secretKey: SecretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKeyBase64))

    @Value("\${spring.application.name}")
    private lateinit var issuer: String

    @Value("\${jwt.access-key-expiration-s}")
    private var accessKeyExpirationInS: Long = 0

    private val accessKeyExpirationInMs: Long
        get() = accessKeyExpirationInS * 100


    fun createJwt(email: String): String {

        val issuedAt = Date(System.currentTimeMillis())

        return Jwts.builder()
            .subject(email)
            .issuer(issuer)
            .issuedAt(issuedAt)
            .expiration(Date(issuedAt.time + accessKeyExpirationInMs))
            .signWith(secretKey)
            .compact()
    }

}