package com.sherpa.interview.domain.websocket.command.receive;

import java.io.IOException;

import com.sherpa.interview.domain.websocket.WebSocketCommand;

public class ClientUpdateMindmapCommand implements WebSocketCommand {

	private final ClientUpdateCommandContext clientUpdateCommandContext;

	public ClientUpdateMindmapCommand(ClientUpdateCommandContext clientUpdateCommandContext) {
		this.clientUpdateCommandContext = clientUpdateCommandContext;
	}

	@Override
	public void execute() throws IOException {

	}
}
