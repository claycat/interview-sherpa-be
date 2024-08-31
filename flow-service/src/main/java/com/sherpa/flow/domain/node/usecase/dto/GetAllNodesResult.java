package com.sherpa.flow.domain.node.usecase.dto;

import java.util.List;

import com.sherpa.flow.domain.node.Node;

import lombok.Builder;

@Builder
public record GetAllNodesResult(List<Node> nodes) {

}
