package com.sherpa.interview.domain.websocket.command;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sherpa.interview.domain.websocket.WebSocketCommand;
import com.sherpa.interview.domain.websocket.command.clientconnect.ClientConnectCommand;
import com.sherpa.interview.domain.websocket.command.enums.ClientCommandEnum;
import com.sherpa.interview.domain.websocket.command.enums.CommandEnum;

class WebSocketCommandFactoryTest {

	@Mock
	private ClientConnectCommand clientConnectCommand;

	@Mock
	private WebSocketCommand anotherCommand;

	private WebSocketCommandFactory webSocketCommandFactory;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

		when(clientConnectCommand.getCommandType()).thenReturn(ClientCommandEnum.CLIENT_CONNECT_REQUEST);

		List<WebSocketCommand> commands = List.of(clientConnectCommand, anotherCommand);
		webSocketCommandFactory = new WebSocketCommandFactory(commands);
	}

	@Test
	@DisplayName("getCommand should return the correct command based on CommandEnum")
	void getCommandReturnsCorrectCommand() {
		// When
		WebSocketCommand command = webSocketCommandFactory.getCommand(
			ClientCommandEnum.CLIENT_CONNECT_REQUEST);

		// Then
		assertEquals(clientConnectCommand, command);
	}

	@Test
	@DisplayName("getCommand should return null for unknown CommandEnum")
	void getCommandReturnsNullForUnknownCommandEnum() {
		// When
		CommandEnum unknownCommandEnum = mock(CommandEnum.class);
		WebSocketCommand command = webSocketCommandFactory.getCommand(unknownCommandEnum);

		// Then
		assertNull(command);
	}
}