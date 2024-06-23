package com.sherpa.interview.domain.node.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sherpa.interview.domain.node.usecase.GetAllNodesUseCase;

@RestController
@RequestMapping("/nodes")
public class NodeController {

	private final GetAllNodesUseCase getAllNodesUseCase;

	public NodeController(GetAllNodesUseCase getAllNodesUseCase) {
		this.getAllNodesUseCase = getAllNodesUseCase;
	}

}
