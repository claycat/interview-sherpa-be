package com.sherpa.interview.domain.edge;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Edge {
	private String id;
	private String source;
	private String target;
}