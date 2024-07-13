package com.sherpa.interview.domain.websocket.command.clientconnect;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherpa.interview.domain.flow.Flow;
import com.sherpa.interview.domain.flow.repository.FlowRepository;
import com.sherpa.interview.domain.websocket.WebSocketCommand;
import com.sherpa.interview.domain.websocket.command.enums.ClientCommandEnum;
import com.sherpa.interview.domain.websocket.command.enums.CommandEnum;
import com.sherpa.interview.domain.websocket.command.enums.ServerCommandEnum;
import com.sherpa.interview.domain.websocket.command.message.WebSocketServerMessage;

@Component
public class ClientConnectCommand implements WebSocketCommand {

	private final FlowRepository flowRepository;
	private final ObjectMapper objectMapper;

	@Autowired
	public ClientConnectCommand(FlowRepository flowRepository, ObjectMapper objectMapper) {
		this.flowRepository = flowRepository;
		this.objectMapper = objectMapper;
	}

	@Override
	public void execute(WebSocketSession session, TextMessage message) throws IOException {
		sendFlowToClient(session);
	}

	@Override
	public CommandEnum getCommandType() {
		return ClientCommandEnum.CLIENT_CONNECT_REQUEST;
	}

	private void sendFlowToClient(WebSocketSession session) throws IOException {
		var flow = flowRepository.findAll().getFirst();

		var message = WebSocketServerMessage.<Flow>builder()
			.command(ServerCommandEnum.SERVER_SEND_FLOW_RESPONSE)
			.data(flow)
			.build();

		session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
	}

}
