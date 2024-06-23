package com.sherpa.interview.domain.node.nodedata;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class NodeData {
	private String label;
	private String question;
	private String answer;

	@Builder
	public NodeData(String label, String question, String answer) {
		this.label = label;
		this.question = question;
		this.answer = answer;
	}
}
