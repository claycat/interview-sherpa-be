package com.sherpa.flow.domain.websocket;


import com.sherpa.flow.domain.websocket.command.enums.CommandEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class WebSocketMessage<T> {
	private CommandEnum command;
	private T data;
}
