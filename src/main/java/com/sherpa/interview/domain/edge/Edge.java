package com.sherpa.interview.domain.edge;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document(collection = "edges")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Edge {
	@Id
	private String id;
	private String source;
	private String target;
}