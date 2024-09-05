package com.sherpa.member.member.exception;

import com.sherpa.httpclient.DefinedException;
import com.sherpa.member.exception.code.MemberExceptionCode;

public class MemberNotFoundException extends DefinedException {
	public MemberNotFoundException(String email) {
		super(MemberExceptionCode.MEMBER_NOT_FOUND, "Member with email " + email + " not found");
	}
}
