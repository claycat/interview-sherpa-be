package com.sherpa.interview.domain.websocket;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherpa.interview.domain.flow.repository.FlowRepository;
import com.sherpa.interview.domain.websocket.command.CommandEnum;

@Component
public class SendMindmapCommand implements WebSocketCommand {

	private final ObjectMapper objectMapper;
	private final FlowRepository flowRepository;

	@Autowired
	public SendMindmapCommand(ObjectMapper objectMapper, FlowRepository flowRepository) {
		this.objectMapper = objectMapper;
		this.flowRepository = flowRepository;
	}

	@Override
	public void execute(WebSocketSession session) throws IOException {
		var flows = flowRepository.findAll();

		var message = WebSocketMessage.builder()
			.command(CommandEnum.SENDMINDMAP)
			.data(flows.getFirst())
			.build();

		session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));

	}

}
