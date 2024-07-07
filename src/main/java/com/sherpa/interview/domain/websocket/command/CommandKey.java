package com.sherpa.interview.domain.websocket.command;

import com.sherpa.interview.domain.websocket.command.enums.ClientCommandEnum;

import lombok.Builder;

@Builder
public record CommandKey(ClientCommandEnum commandType) {}
