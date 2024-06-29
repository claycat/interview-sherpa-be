package com.sherpa.interview.domain.websocket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherpa.interview.domain.websocket.command.CommandKey;
import com.sherpa.interview.domain.websocket.command.WebSocketCommandFactory;
import com.sherpa.interview.domain.websocket.command.message.WebSocketClientMessage;

@Component
public class WebSocketMessageService {

	private final ObjectMapper objectMapper;
	private final WebSocketCommandFactory webSocketCommandFactory;
	private final CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

	@Autowired
	public WebSocketMessageService(ObjectMapper objectMapper, WebSocketCommandFactory webSocketCommandFactory) {
		this.objectMapper = objectMapper;
		this.webSocketCommandFactory = webSocketCommandFactory;
	}

	public void addSession(WebSocketSession session) {
		sessions.add(session);
	}

	public void removeSession(WebSocketSession session) {
		sessions.remove(session);
	}

	public void processReceivedMessage(WebSocketSession session, TextMessage message) throws IOException {
		var payload = message.getPayload();
		var webSocketMessage = objectMapper.readValue(payload, WebSocketClientMessage.class);
		var commandType = webSocketMessage.getCommand();

		var commandKey = CommandKey.builder()
			.commandType(commandType)
			.textMessage(message)
			.sourceSession(session)
			.sessions(sessions)
			.build();

		var responseCommand = webSocketCommandFactory.getCommand(commandKey);
		responseCommand.execute();
	}

}
