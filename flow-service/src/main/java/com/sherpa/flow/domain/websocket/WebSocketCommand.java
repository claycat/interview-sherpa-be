package com.sherpa.flow.domain.websocket;

import java.io.IOException;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.sherpa.flow.domain.websocket.command.enums.CommandEnum;

public interface WebSocketCommand {
	void execute(WebSocketSession session, TextMessage message) throws IOException;

	CommandEnum getCommandType();
}
