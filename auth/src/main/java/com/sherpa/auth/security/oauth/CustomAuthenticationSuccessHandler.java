package com.sherpa.auth.security.oauth;

import java.io.IOException;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.core.Authentication;

import com.sherpa.auth.security.JwtProvider;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private JwtProvider jwtProvider;

	public CustomAuthenticationSuccessHandler(JwtProvider jwtTokenProvider) {
		this.jwtProvider = jwtTokenProvider;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws
		IOException {
		String authorizationCode = request.getParameter("code");
		if (authorizationCode != null) {
			String redirectUrl = "http://localhost:3000/oauth/redirected/google?code=" + authorizationCode;
			getRedirectStrategy().sendRedirect(request, response, redirectUrl);
		}
	}
}