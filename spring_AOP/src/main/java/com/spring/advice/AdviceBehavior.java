package com.spring.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceBehavior {

	
	public void chikachika() {
		System.out.println("열심히 양치질을 합니다~");
	}
	
	//joinPoint : around
	public void chikachkaAround(ProceedingJoinPoint joinPoint)throws Throwable{
		System.out.println("한번닦았는데...");
		
		joinPoint.proceed();
		
		System.out.println("또 닦아요!!!!!!");
		
	}
	
}
