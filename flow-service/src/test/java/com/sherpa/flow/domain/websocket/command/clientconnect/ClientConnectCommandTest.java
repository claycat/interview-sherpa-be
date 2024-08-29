package com.sherpa.flow.domain.websocket.command.clientconnect;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.LinkedList;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherpa.flow.domain.flow.Flow;
import com.sherpa.flow.domain.flow.repository.FlowRepository;
import com.sherpa.flow.domain.websocket.command.enums.ClientCommandEnum;
import com.sherpa.flow.domain.websocket.command.enums.CommandEnum;
import com.sherpa.flow.domain.websocket.command.enums.ServerCommandEnum;
import com.sherpa.flow.domain.websocket.command.message.WebSocketServerMessage;

class ClientConnectCommandTest {

	private ClientConnectCommand clientConnectCommand;

	@Mock
	private FlowRepository flowRepository;

	@Mock
	private WebSocketSession session;

	private final ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		clientConnectCommand = new ClientConnectCommand(flowRepository, objectMapper);
	}

	@Test
	@DisplayName("given flow > when command executed > sends proper message to session")
	void executeSuccess() throws IOException {
		//given
		Flow flow = Flow.builder().build();
		LinkedList<Flow> flows = new LinkedList<>();
		flows.add(flow);

		var messageToSend = WebSocketServerMessage.<Flow>builder()
			.command(ServerCommandEnum.SERVER_SEND_FLOW_RESPONSE)
			.data(flow)
			.build();

		when(flowRepository.findAll()).thenReturn(flows);

		//when
		clientConnectCommand.execute(session, null);

		//then
		verify(flowRepository).findAll();
		verify(session).sendMessage(new TextMessage(objectMapper.writeValueAsString(messageToSend)));

	}

	@Test
	@DisplayName("given none > when command type requested > then returns command type")
	void getCommandTypeSuccess() {
		//given - when
		CommandEnum command = clientConnectCommand.getCommandType();

		//then
		Assertions.assertThat(command).isEqualTo(ClientCommandEnum.CLIENT_CONNECT_REQUEST);
	}
}