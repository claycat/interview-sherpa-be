package com.sherpa.interview.domain.websocket.command;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.sherpa.interview.domain.websocket.command.enums.ClientCommandEnum;

import lombok.Builder;

@Builder
public record CommandKey(CopyOnWriteArrayList<WebSocketSession> sessions, WebSocketSession sourceSession,
						 ClientCommandEnum commandType,
						 TextMessage textMessage) {
}
