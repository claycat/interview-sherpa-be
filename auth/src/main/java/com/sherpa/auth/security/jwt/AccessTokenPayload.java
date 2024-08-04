package com.sherpa.auth.security.jwt;

import java.util.Date;

import lombok.Builder;

@Builder
public record AccessTokenPayload(String email, Date issuedAt) {

}
