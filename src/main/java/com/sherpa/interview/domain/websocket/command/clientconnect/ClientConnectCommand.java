package com.sherpa.interview.domain.websocket.command.clientconnect;

import java.io.IOException;

import org.springframework.web.socket.TextMessage;

import com.sherpa.interview.domain.flow.Flow;
import com.sherpa.interview.domain.websocket.WebSocketCommand;
import com.sherpa.interview.domain.websocket.command.enums.ServerCommandEnum;
import com.sherpa.interview.domain.websocket.command.message.WebSocketServerMessage;

public class ClientConnectCommand implements WebSocketCommand {

	private final ClientConnectContext clientConnectContext;

	public ClientConnectCommand(ClientConnectContext clientConnectContext) {
		this.clientConnectContext = clientConnectContext;
	}

	@Override
	public void execute() throws IOException {
		sendFlowToClient();
	}

	private void sendFlowToClient() throws IOException {
		var flow = clientConnectContext.flowRepository().findAll().getFirst();

		var message = WebSocketServerMessage.<Flow>builder()
			.command(ServerCommandEnum.SERVER_SEND_FLOW_RESPONSE)
			.data(flow)
			.build();

		try (var session = clientConnectContext.session()) {
			session.sendMessage(
				new TextMessage(clientConnectContext.objectMapper().writeValueAsString(message)));
		}

	}

}
