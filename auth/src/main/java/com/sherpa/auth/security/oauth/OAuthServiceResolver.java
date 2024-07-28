package com.sherpa.auth.security.oauth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sherpa.auth.constant.OAuthProviderEnum;

@Component
public class OAuthServiceResolver {

	private final Map<OAuthProviderEnum, OAuthService> oAuthServiceMap = new HashMap<>();

	@Autowired
	public OAuthServiceResolver(List<OAuthService> services) {
		for (OAuthService service : services) {
			oAuthServiceMap.put(service.getProvider(), service);
		}
	}

	public OAuthService resolve(OAuthProviderEnum provider) {
		return oAuthServiceMap.get(provider);
	}

}