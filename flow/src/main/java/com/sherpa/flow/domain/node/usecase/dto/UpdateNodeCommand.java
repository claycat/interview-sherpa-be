package com.sherpa.flow.domain.node.usecase.dto;

import com.sherpa.flow.domain.node.Node;

import lombok.Builder;

@Builder
public record UpdateNodeCommand(Node node) {
}
