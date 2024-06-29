package com.sherpa.interview.domain.websocket;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherpa.interview.domain.flow.Flow;
import com.sherpa.interview.domain.flow.repository.FlowRepository;
import com.sherpa.interview.domain.websocket.command.clientconnect.ClientConnectCommand;

class SendMindmapCommandTest {

	@InjectMocks
	private ClientConnectCommand clientConnectCommand;

	@Mock
	private FlowRepository flowRepository;

	@Mock
	private WebSocketSession session;

	@Mock
	private ObjectMapper objectMapper;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void execute() throws IOException {
		//given
		Flow flow = Flow.builder().build();
		LinkedList<Flow> flows = new LinkedList<>();
		flows.add(flow);
		String serializedMessage = "serialized_message";

		when(flowRepository.findAll()).thenReturn(flows);
		when(objectMapper.writeValueAsString(any())).thenReturn(serializedMessage);

		//when
		//clientConnectCommand.execute(session);

		//then
		verify(flowRepository).findAll();
		verify(objectMapper).writeValueAsString(any());
		verify(session).sendMessage(new TextMessage(serializedMessage));

	}
}