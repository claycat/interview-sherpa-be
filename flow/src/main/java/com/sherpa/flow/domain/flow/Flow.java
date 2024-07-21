package com.sherpa.flow.domain.flow;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.sherpa.flow.domain.Viewport.Viewport;
import com.sherpa.flow.domain.edge.Edge;
import com.sherpa.flow.domain.node.Node;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document("flows")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Flow {
	@Id
	@Field("_id")
	private String documentId;
	private List<Node> nodes;
	private List<Edge> edges;
	private Viewport viewport;

}
