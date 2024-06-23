package com.sherpa.interview.domain.node.usecase.dto;

import java.util.List;

import com.sherpa.interview.domain.node.Node;

import lombok.Builder;

@Builder
public record GetAllNodesResult(List<Node> nodes) {

}
