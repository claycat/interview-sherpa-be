package com.sherpa.auth.user.exception;

import com.sherpa.auth.exception.code.MemberExceptionCode;
import com.sherpa.httpclient.DefinedException;

public class MemberNotFoundException extends DefinedException {
	public MemberNotFoundException() {
		super(MemberExceptionCode.MEMBER_NOT_FOUND);
	}
}
