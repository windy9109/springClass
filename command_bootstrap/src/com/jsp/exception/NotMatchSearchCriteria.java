package com.jsp.exception;
//예외처리
public class NotMatchSearchCriteria extends Exception{

	public NotMatchSearchCriteria() {
		super("SearchCriteria 타입이 아닙니다.");
	}
}
