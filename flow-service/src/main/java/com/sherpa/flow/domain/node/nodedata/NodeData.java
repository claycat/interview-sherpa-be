package com.sherpa.flow.domain.node.nodedata;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NodeData {
	private String label;
	private String question;
	private List<String> answers;

}
