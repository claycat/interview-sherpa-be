package com.sherpa.interview.domain.websocket.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherpa.interview.domain.flow.repository.FlowRepository;
import com.sherpa.interview.domain.websocket.WebSocketCommand;
import com.sherpa.interview.domain.websocket.command.clientconnect.ClientConnectCommand;
import com.sherpa.interview.domain.websocket.command.clientconnect.ClientConnectContext;
import com.sherpa.interview.domain.websocket.command.enums.ClientCommandEnum;
import com.sherpa.interview.domain.websocket.command.receive.ClientUpdateCommandContext;
import com.sherpa.interview.domain.websocket.command.receive.ClientUpdateMindmapCommand;

@Component
public class WebSocketCommandFactory {

	private final ObjectMapper objectMapper;
	private final FlowRepository flowRepository;

	@Autowired
	public WebSocketCommandFactory(ObjectMapper objectMapper, FlowRepository flowRepository) {
		this.objectMapper = objectMapper;
		this.flowRepository = flowRepository;
	}

	public WebSocketCommand getCommand(CommandKey commandKey) {

		switch (commandKey.commandType()) {
			case ClientCommandEnum.CLIENT_CONNECT_REQUEST -> {
				return new ClientConnectCommand(ClientConnectContext.builder()
					.session(commandKey.sourceSession())
					.flowRepository(flowRepository)
					.objectMapper(objectMapper)
					.build());
			}
			case ClientCommandEnum.CLIENT_UPDATE_FLOW_REQUEST -> {
				return new ClientUpdateMindmapCommand(ClientUpdateCommandContext.builder()
					.sessions(commandKey.sessions())
					.sourceSession(commandKey.sourceSession())
					.flowRepository(flowRepository)
					.objectMapper(objectMapper)
					.build());
			}
			default -> {
				throw new IllegalArgumentException("Unknown Command Type");
			}
		}
	}

}
