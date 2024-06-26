package com.sherpa.interview.domain.websocket;

import java.io.IOException;

import org.springframework.web.socket.WebSocketSession;

public interface WebSocketCommand {
	void execute(WebSocketSession session) throws IOException;
}
