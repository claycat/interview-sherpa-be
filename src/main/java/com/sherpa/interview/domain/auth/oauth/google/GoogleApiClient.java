package com.sherpa.interview.domain.auth.oauth.google;

import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.PostExchange;

public interface GoogleApiClient {

	@PostExchange(url = "https://oauth2.googleapis.com/token", contentType = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	GoogleToken fetchToken(@RequestParam MultiValueMap<String, String> params);
}