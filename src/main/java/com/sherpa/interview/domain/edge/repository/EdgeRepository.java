package com.sherpa.interview.domain.edge.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sherpa.interview.domain.edge.Edge;

public interface EdgeRepository extends MongoRepository<Edge, String> {
}
