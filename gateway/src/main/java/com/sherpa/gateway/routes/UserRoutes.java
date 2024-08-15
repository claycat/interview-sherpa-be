package com.sherpa.gateway.routes;

import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.*;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class UserRoutes {

	@Bean
	public RouterFunction<ServerResponse> getRoute() {
		return route().GET("/test", http("http://localhost:8080/test")).build();
	}

}
