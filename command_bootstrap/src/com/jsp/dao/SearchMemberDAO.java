package com.jsp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.command.SearcjCriteria;
import com.jsp.dto.MemberVO;

public interface SearchMemberDAO extends MemberDAO {

	
	//회원리스트조회
		List<MemberVO> selectSeachMemberList(SqlSession session, SearcjCriteria cri)throws Exception;
		int selectSeachMemberListCount(SqlSession session, SearcjCriteria cri)throws Exception;
		
		
	
}
