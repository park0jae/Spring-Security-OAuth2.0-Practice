package com.pgms.apimember.exception;

import lombok.Getter;

@Getter
public class MemberException extends RuntimeException {

	private final MemberErrorCode errorCode;

	public MemberException(MemberErrorCode errorCode) {
		this.errorCode = errorCode;
	}
}
