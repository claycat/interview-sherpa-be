package com.sherpa.flow.domain.edge.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sherpa.flow.domain.edge.Edge;

public interface EdgeRepository extends MongoRepository<Edge, String> {
}
