package com.sherpa.interview.domain.websocket;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherpa.interview.domain.websocket.command.WebSocketCommandFactory;
import com.sherpa.interview.domain.websocket.command.message.WebSocketClientMessage;

@Component
public class WebSocketMessageService {

	private final ObjectMapper objectMapper;
	private final WebSocketCommandFactory webSocketCommandFactory;
	private final WebSocketSessionManager webSocketSessionManager;

	@Autowired
	public WebSocketMessageService(ObjectMapper objectMapper, WebSocketCommandFactory webSocketCommandFactory,
		WebSocketSessionManager webSocketSessionManager) {
		this.objectMapper = objectMapper;
		this.webSocketCommandFactory = webSocketCommandFactory;
		this.webSocketSessionManager = webSocketSessionManager;
	}

	public void processReceivedMessage(WebSocketSession session, TextMessage message) throws IOException {
		var payload = message.getPayload();
		var webSocketMessage = objectMapper.readValue(payload, WebSocketClientMessage.class);
		var commandType = webSocketMessage.getCommand();

		var responseCommand = webSocketCommandFactory.getCommand(commandType);
		responseCommand.execute(session, message);
	}

}
