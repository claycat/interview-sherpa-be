package com.sherpa.interview.domain.flow.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sherpa.interview.domain.flow.Flow;

@Repository
public interface FlowRepository extends MongoRepository<Flow, String> {
}
