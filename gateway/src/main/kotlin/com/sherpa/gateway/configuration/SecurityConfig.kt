package com.sherpa.gateway.configuration

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationFailureHandler
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationSuccessHandler
import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler


@EnableWebFluxSecurity
@Configuration
class SecurityConfig {
    private val logger = LoggerFactory.getLogger(javaClass)


    @Bean
    fun springSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        http
            .csrf { it.disable() }
            .formLogin { it.disable() }
            .httpBasic { it.disable() }
            .authorizeExchange {
                it.pathMatchers("/test", "/login", "/error", "/webjars/**").permitAll()
                it.anyExchange().authenticated()
            }
            .requestCache {
                it.disable()
            }
            .oauth2Login {
                it.authenticationSuccessHandler(successHandler())
                it.authenticationFailureHandler(failureHandler())
            }
        return http.build()
    }

    @Bean
    fun successHandler(): RedirectServerAuthenticationSuccessHandler {
        return RedirectServerAuthenticationSuccessHandler("/signin/success")
    }


    @Bean
    fun failureHandler(): ServerAuthenticationFailureHandler {
        return RedirectServerAuthenticationFailureHandler("/signin/failure")
    }

}