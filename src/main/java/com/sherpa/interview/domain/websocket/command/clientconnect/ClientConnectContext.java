package com.sherpa.interview.domain.websocket.command.clientconnect;

import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherpa.interview.domain.flow.repository.FlowRepository;
import com.sherpa.interview.domain.websocket.command.CommandContext;

import lombok.Builder;

@Builder
public record ClientConnectContext(FlowRepository flowRepository, ObjectMapper objectMapper,
								   WebSocketSession session, ClientConnectPayload payload)
	implements CommandContext {
}
