package com.sherpa.gateway.domain.auth.oauthattributes

import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory

@Slf4j
class OAuthAttributes(
    val name: String,
    val email: String,
    val profileURL: String
) {

    companion object {
        private val logger = LoggerFactory.getLogger(OAuthAttributes::class.java)

        fun of(attributes: Map<String, Any>, provider: OAuthProvider): OAuthAttributes {

            try {
                return when (provider) {
                    OAuthProvider.GOOGLE -> ofGoogle(attributes)
                    OAuthProvider.GITHUB -> throw RuntimeException("not yet")
                }
            } catch (e: Exception) {
                logger.error("Error creating OAuthAttributes from attributes: $attributes", e)
                throw e
            }
        }

        private fun ofGoogle(attributes: Map<String, Any>): OAuthAttributes {
            return OAuthAttributes(
                name = attributes["name"] as String,
                email = attributes["email"] as String,
                profileURL = attributes["picture"] as String
            )
        }
    }


}

