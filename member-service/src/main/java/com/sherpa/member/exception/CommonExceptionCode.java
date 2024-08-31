package com.sherpa.member.exception;

import org.springframework.http.HttpStatus;

import com.sherpa.httpclient.ExceptionCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonExceptionCode implements ExceptionCode {
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버 측에서 문제가 발생했습니다.");

	private final int httpStatus;
	private final String message;
}