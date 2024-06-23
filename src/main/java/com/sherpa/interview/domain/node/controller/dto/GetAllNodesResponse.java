package com.sherpa.interview.domain.node.controller.dto;

import java.util.List;

import com.sherpa.interview.domain.node.Node;

import lombok.Builder;

@Builder
public record GetAllNodesResponse(List<Node> nodes) {
}

