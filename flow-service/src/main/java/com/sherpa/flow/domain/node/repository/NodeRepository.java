package com.sherpa.flow.domain.node.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sherpa.flow.domain.node.Node;

public interface NodeRepository extends MongoRepository<Node, String> {
}
