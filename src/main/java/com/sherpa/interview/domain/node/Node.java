package com.sherpa.interview.domain.node;

import org.springframework.data.mongodb.core.mapping.Document;

import com.sherpa.interview.domain.node.nodedata.NodeData;

import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "nodes")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Node {
	@Id
	private String id;
	private String type;
	private NodeData data;
	private Position position;

	@Builder
	public Node(String id, String type, NodeData data, Position position) {
		this.id = id;
		this.type = type;
		this.data = data;
		this.position = position;
	}
}
