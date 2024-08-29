package com.sherpa.flow.configuration;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

@DataMongoTest
@Testcontainers
public class MongoDbContainerTest {

	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:5.0.3"));

	@Autowired
	private MongoTemplate mongoTemplate;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	void testKeyValueInsertion() {
		DBObject objectToSave = BasicDBObjectBuilder.start()
			.add("key", "value")
			.get();

		// When
		mongoTemplate.save(objectToSave, "collection");

		// Then
		assertThat(mongoTemplate.findAll(DBObject.class, "collection"))
			.extracting("key")
			.containsOnly("value");
	}
}
