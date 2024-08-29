package com.sherpa.httpclient

import org.slf4j.LoggerFactory
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

private val logger = LoggerFactory.getLogger("WebClientErrorLogger")

fun WebClient.RequestHeadersSpec<*>.retrieveOrPropagate(): WebClient.ResponseSpec {
    return this.retrieve()
        .onStatus({ status -> status.isError }) { response ->
            response.bodyToMono(ErrorResponse::class.java).flatMap { errorBody ->
                val exception = ApiException(errorBody)
                logger.error(exception.getFormattedMessage())
                Mono.error(exception)
            }
        }
}