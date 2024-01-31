package com.pgms.apimember.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum MemberErrorCode {

	MEMBER_NOT_FOUND("mem-404/01", HttpStatus.NOT_FOUND, "회원을 찾을 수 없습니다."),
	VALIDATION_FAILED("mem-400/01", HttpStatus.BAD_REQUEST, "입력값에 대한 검증에 실패했습니다.");

	private final String code;
	private final HttpStatus status;
	private final String message;

	MemberErrorCode(String code, HttpStatus status, String message) {
		this.code = code;
		this.status = status;
		this.message = message;
	}
}
