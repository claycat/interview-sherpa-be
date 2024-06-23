package com.sherpa.interview.domain.node.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sherpa.interview.domain.node.Node;

public interface NodeRepository extends MongoRepository<Node, String> {
}
