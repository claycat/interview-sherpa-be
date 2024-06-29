package com.sherpa.interview.domain.websocket;

import java.io.IOException;

public interface WebSocketCommand {
	void execute() throws IOException;
}
