package com.sherpa.interview.configuration.websocket.handler;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class NodeWebSocketHandler extends TextWebSocketHandler {
	private final CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessions.add(session);
		sendWelcomeMessage(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		for (WebSocketSession s : sessions) {
			if (s.isOpen() && !s.getId().equals(session.getId())) {
				s.sendMessage(message);
			}
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessions.remove(session);
	}

	public void broadcast(String message) throws IOException {
		for (WebSocketSession session : sessions) {
			if (session.isOpen()) {
				session.sendMessage(new TextMessage(message));
			}
		}
	}

	private void sendWelcomeMessage(WebSocketSession session) throws IOException {
		if (session.isOpen()) {
			session.sendMessage(new TextMessage("hi"));
		}
	}
}
