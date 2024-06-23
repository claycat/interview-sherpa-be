package com.sherpa.interview.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClients;

@TestConfiguration
public class EmbeddedMongoConfig {

	@Bean
	@Primary
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(MongoClients.create("mongodb://localhost:27017/test"), "test");
	}
}
