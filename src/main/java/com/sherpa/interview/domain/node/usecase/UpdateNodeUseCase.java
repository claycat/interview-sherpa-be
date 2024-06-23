package com.sherpa.interview.domain.node.usecase;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherpa.interview.configuration.websocket.handler.NodeWebSocketHandler;
import com.sherpa.interview.domain.node.repository.NodeRepository;
import com.sherpa.interview.domain.node.usecase.dto.UpdateNodeCommand;

@Service
public class UpdateNodeUseCase {

	private final NodeWebSocketHandler webSocketHandler;
	private final NodeRepository nodeRepository;
	private final ObjectMapper objectMapper;

	@Autowired
	public UpdateNodeUseCase(final NodeWebSocketHandler webSocketHandler, NodeRepository nodeRepository,
		ObjectMapper objectMapper) {
		this.webSocketHandler = webSocketHandler;
		this.nodeRepository = nodeRepository;
		this.objectMapper = objectMapper;
	}

	public void updateNode(UpdateNodeCommand updateNodeCommand) throws IOException {
		var node = updateNodeCommand.node();
		nodeRepository.save(node);
		webSocketHandler.broadcast(objectMapper.writeValueAsString(node));
	}
}
