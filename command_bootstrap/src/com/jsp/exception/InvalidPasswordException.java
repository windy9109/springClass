package com.jsp.exception;

public class InvalidPasswordException extends Exception{

	public InvalidPasswordException() {
		super("패스워드가 일치 하지 않습니다.");
	}
}
