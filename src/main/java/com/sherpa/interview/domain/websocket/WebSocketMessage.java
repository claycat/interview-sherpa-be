package com.sherpa.interview.domain.websocket;

import com.sherpa.interview.domain.websocket.command.CommandEnum;

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
