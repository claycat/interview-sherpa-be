package com.sherpa.interview.domain.websocket;

import static org.mockito.Mockito.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherpa.interview.domain.websocket.command.WebSocketCommandFactory;
import com.sherpa.interview.domain.websocket.command.clientconnect.ClientConnectCommand;
import com.sherpa.interview.domain.websocket.command.enums.ClientCommandEnum;
import com.sherpa.interview.domain.websocket.command.message.WebSocketClientMessage;

class WebSocketMessageServiceTest {

	@InjectMocks
	private WebSocketMessageService webSocketMessageService;

	@Mock
	private WebSocketCommandFactory webSocketCommandFactory;

	@Mock
	private WebSocketSession session;

	@Mock
	private WebSocketSessionManager webSocketSessionManager;

	@Mock
	private ClientConnectCommand clientConnectCommand;

	private final ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		webSocketMessageService = new WebSocketMessageService(objectMapper, webSocketCommandFactory,
			webSocketSessionManager);
	}

	@Test
	void processReceivedMessageSuccess() throws IOException {

		//given
		var commandType = ClientCommandEnum.CLIENT_CONNECT_REQUEST;
		var message = WebSocketClientMessage.builder()
			.command(commandType)
			.data(null)
			.build();

		var textMessage = new TextMessage(objectMapper.writeValueAsString(message));

		doReturn(clientConnectCommand).when(webSocketCommandFactory).getCommand(commandType);
		doNothing().when(clientConnectCommand).execute(eq(session), any(TextMessage.class));

		//when
		webSocketMessageService.processReceivedMessage(session, textMessage);

		//then
		verify(webSocketCommandFactory).getCommand(commandType);
		verify(clientConnectCommand).execute(session, textMessage);

	}

}