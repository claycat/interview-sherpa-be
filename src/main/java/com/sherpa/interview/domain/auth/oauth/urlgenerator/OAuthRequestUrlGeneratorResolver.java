package com.sherpa.interview.domain.auth.oauth.urlgenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sherpa.interview.domain.auth.oauth.constant.OAuthProviderEnum;

@Component
public class OAuthRequestUrlGeneratorResolver {

	private final Map<OAuthProviderEnum, OAuthRequestUrlGenerator> requestUrlGeneratorMap = new HashMap<>();

	@Autowired
	public OAuthRequestUrlGeneratorResolver(List<OAuthRequestUrlGenerator> generators) {
		for (OAuthRequestUrlGenerator generator : generators) {
			requestUrlGeneratorMap.put(generator.getProvider(), generator);
		}
	}

	public OAuthRequestUrlGenerator getRequestUrlGenerator(OAuthProviderEnum provider) {
		return Optional.ofNullable(requestUrlGeneratorMap.get(provider))
			.orElseThrow(() -> new RuntimeException("Not Supported OAuth"));
	}

}

