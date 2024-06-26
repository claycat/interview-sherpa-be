package com.sherpa.interview.domain.websocket.command;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sherpa.interview.domain.websocket.SendMindmapCommand;
import com.sherpa.interview.domain.websocket.WebSocketCommand;

import jakarta.annotation.PostConstruct;

@Component
public class WebSocketCommandFactory {

	private final SendMindmapCommand sendMindmapCommand;

	private final HashMap<CommandEnum, WebSocketCommand> commandHashMap = new HashMap<>();

	@Autowired
	public WebSocketCommandFactory(SendMindmapCommand sendMindmapCommand) {
		this.sendMindmapCommand = sendMindmapCommand;
	}

	@PostConstruct
	public void init() {
		commandHashMap.put(CommandEnum.SENDMINDMAP, sendMindmapCommand);
	}

	public WebSocketCommand getCommand(CommandEnum command) {
		return commandHashMap.get(command);
	}

}
