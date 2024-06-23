package com.sherpa.interview.domain.node.usecase;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherpa.interview.configuration.websocket.handler.NodeWebSocketHandler;
import com.sherpa.interview.domain.node.repository.NodeRepository;
import com.sherpa.interview.domain.node.usecase.dto.GetAllNodesResult;
import com.sherpa.interview.domain.node.usecase.dto.UpdateNodeCommand;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GetAllNodesUseCase {

	private final NodeWebSocketHandler webSocketHandler;
	private final NodeRepository nodeRepository;
	private final ObjectMapper objectMapper;

	@Autowired
	public GetAllNodesUseCase(final NodeWebSocketHandler webSocketHandler, NodeRepository nodeRepository,
		ObjectMapper objectMapper) {
		this.webSocketHandler = webSocketHandler;
		this.nodeRepository = nodeRepository;
		this.objectMapper = objectMapper;
	}

	public GetAllNodesResult getAllNodes(UpdateNodeCommand updateNodeCommand) throws IOException {
		var nodes = nodeRepository.findAll();
		return GetAllNodesResult.builder()
			.nodes(nodes)
			.build();
	}
}
