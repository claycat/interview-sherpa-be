package com.sherpa.flow.domain.node.usecase;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherpa.flow.domain.node.repository.NodeRepository;
import com.sherpa.flow.domain.node.usecase.dto.GetAllNodesResult;
import com.sherpa.flow.domain.node.usecase.dto.UpdateNodeCommand;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GetAllNodesUseCase {

	private final WebSocketHandler webSocketHandler;
	private final NodeRepository nodeRepository;
	private final ObjectMapper objectMapper;

	@Autowired
	public GetAllNodesUseCase(final WebSocketHandler webSocketHandler, NodeRepository nodeRepository,
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
