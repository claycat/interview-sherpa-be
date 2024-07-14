package com.sherpa.interview.configuration.httpinterface;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpInterfaceConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}