package com.sherpa.interview.configuration.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.sherpa.interview.configuration.websocket.handler.NodeWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	private final NodeWebSocketHandler nodeWebSocketHandler;

	@Autowired
	public WebSocketConfig(NodeWebSocketHandler nodeWebSocketHandler) {
		this.nodeWebSocketHandler = nodeWebSocketHandler;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(nodeWebSocketHandler, "/ws/nodes")
			.setAllowedOrigins("*");
	}

}