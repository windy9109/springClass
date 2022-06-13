package com.jsp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIdException;

public interface MemberService {
	//회원검색
	public List<MemberVO> getMemberList() throws Exception;
	
	//회원상세
	public MemberVO getMember(String id) throws Exception;

	//회원수정
	public void modify(MemberVO member) throws Exception;
	
	public void login(String id, String pwd) throws NotFoundIdException, InvalidPasswordException, SQLException;
}
