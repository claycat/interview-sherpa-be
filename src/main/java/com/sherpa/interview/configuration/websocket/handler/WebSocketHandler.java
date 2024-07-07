package com.sherpa.interview.configuration.websocket.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.sherpa.interview.domain.websocket.WebSocketMessageService;
import com.sherpa.interview.domain.websocket.WebSocketSessionManager;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

	private final WebSocketSessionManager webSocketSessionManager;
	private final WebSocketMessageService messageService;

	@Autowired
	public WebSocketHandler(WebSocketSessionManager webSocketSessionManager, WebSocketMessageService messageService) {
		this.webSocketSessionManager = webSocketSessionManager;
		this.messageService = messageService;
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		webSocketSessionManager.addSession(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		messageService.processReceivedMessage(session, message);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
		webSocketSessionManager.removeSession(session);
	}

}
