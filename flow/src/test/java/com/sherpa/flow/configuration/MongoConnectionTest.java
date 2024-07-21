package com.sherpa.flow.configuration;

import static org.assertj.core.api.Assertions.*;

import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

@DataMongoTest
@Import(EmbeddedMongoConfig.class)
public class MongoConnectionTest {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void testMongoConnection() {
		assertThat(mongoTemplate).isNotNull();

		Document ping = mongoTemplate.executeCommand("{ ping: 1}");
		assertThat(ping).isNotNull();
	}

}


