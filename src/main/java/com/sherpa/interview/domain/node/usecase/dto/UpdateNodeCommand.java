package com.sherpa.interview.domain.node.usecase.dto;

import com.sherpa.interview.domain.node.Node;

import lombok.Builder;

@Builder
public record UpdateNodeCommand(Node node) {
}
