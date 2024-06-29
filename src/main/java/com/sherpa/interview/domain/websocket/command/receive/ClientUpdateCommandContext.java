package com.sherpa.interview.domain.websocket.command.receive;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherpa.interview.domain.flow.repository.FlowRepository;
import com.sherpa.interview.domain.websocket.command.CommandContext;

import lombok.Builder;

@Builder
public record ClientUpdateCommandContext(FlowRepository flowRepository, ObjectMapper objectMapper,
										 CopyOnWriteArrayList<WebSocketSession> sessions,
										 WebSocketSession sourceSession
) implements CommandContext {

}
