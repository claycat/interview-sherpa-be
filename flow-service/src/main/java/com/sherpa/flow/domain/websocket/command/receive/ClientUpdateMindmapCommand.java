package com.sherpa.flow.domain.websocket.command.receive;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherpa.flow.domain.flow.repository.FlowRepository;
import com.sherpa.flow.domain.websocket.WebSocketCommand;
import com.sherpa.flow.domain.websocket.command.enums.ClientCommandEnum;
import com.sherpa.flow.domain.websocket.command.enums.CommandEnum;

@Component
public class ClientUpdateMindmapCommand implements WebSocketCommand {

	private final FlowRepository flowRepository;
	private final ObjectMapper objectMapper;

	@Autowired
	public ClientUpdateMindmapCommand(FlowRepository flowRepository, ObjectMapper objectMapper) {
		this.flowRepository = flowRepository;
		this.objectMapper = objectMapper;
	}

	@Override
	public void execute(WebSocketSession session, TextMessage message) throws IOException {

	}

	@Override
	public CommandEnum getCommandType() {
		return ClientCommandEnum.CLIENT_UPDATE_FLOW_REQUEST;
	}
}
