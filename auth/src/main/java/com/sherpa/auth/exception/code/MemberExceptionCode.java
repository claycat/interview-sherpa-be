package com.sherpa.auth.exception.code;

import org.springframework.http.HttpStatus;

import com.sherpa.httpclient.ExceptionCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberExceptionCode implements ExceptionCode {
	MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "존재하지 않는 멤버입니다.");

	private final int httpStatus;
	private final String message;
}
