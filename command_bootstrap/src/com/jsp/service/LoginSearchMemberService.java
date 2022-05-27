package com.jsp.service;


import org.apache.ibatis.javassist.NotFoundException;

import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIdException;

public interface LoginSearchMemberService extends MemberService{
	
	void login(String id, String pwd)throws NotFoundIdException,InvalidPasswordException, Exception;

}
