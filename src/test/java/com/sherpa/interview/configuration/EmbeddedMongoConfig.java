package com.sherpa.interview.configuration;

import java.io.IOException;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClients;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

@TestConfiguration
public class EmbeddedMongoConfig {

	@Bean
	@Primary
	public MongoTemplate mongoTemplate() throws IOException {
		var mongodConfig = MongodConfig.builder()
			.version(Version.Main.PRODUCTION)
			.net(new Net("localhost", 27017, Network.localhostIsIPv6()))
			.build();

		MongodExecutable mongodExecutable = MongodStarter.getDefaultInstance().prepare(mongodConfig);
		mongodExecutable.start();

		return new MongoTemplate(MongoClients.create("mongodb://localhost:27017/test"), "test");
	}
}
