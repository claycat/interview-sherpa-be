package com.sherpa.member.user.exception;

import com.sherpa.httpclient.DefinedException;
import com.sherpa.member.exception.code.MemberExceptionCode;

public class MemberNotFoundException extends DefinedException {
	public MemberNotFoundException() {
		super(MemberExceptionCode.MEMBER_NOT_FOUND);
	}
}
