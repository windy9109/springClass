package com.jsp.service;

import java.util.List;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.MemberVO;

public interface MemberService {
	List<MemberVO> getMemberList()throws Exception;
	List<MemberVO> getMemberList(Criteria cri)throws Exception;
	

	
	//회원상세
	public MemberVO getMember(String id) throws Exception;
	
	//회원등록
	public void regist(MemberVO member)throws Exception;
	
	//회원수정
	public void modify(MemberVO member)throws Exception;
	
	//회원탈퇴
	public void remove(String id)throws Exception;
	
	//회원상태변경
	void enabled(String id, int enavled)throws Exception;
	
	Map<String, Object> getMemberListforPage(Criteria cri) throws Exception;

	

	
}
