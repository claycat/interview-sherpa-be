package com.sherpa.gateway.domain.auth.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*
import javax.crypto.SecretKey

@Service
class JwtService(
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


    fun createAccessToken(jwtPayload: AccessTokenPayload): String {

        return Jwts.builder()
            .subject(jwtPayload.email)
            .issuer(issuer)
            .issuedAt(jwtPayload.issuedAt)
            .expiration(Date(jwtPayload.issuedAt.time + accessKeyExpirationInMs))
            .signWith(secretKey)
            .compact()
    }

}