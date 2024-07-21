package com.sherpa.flow.domain.flow.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sherpa.flow.domain.flow.Flow;

@Repository
public interface FlowRepository extends MongoRepository<Flow, String> {
}
