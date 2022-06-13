package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.MemberVO;

public interface MemberDAO {
	
	//회원 리스트 조회
	List<MemberVO> selectMemberList(SqlSession session) throws Exception;
	
	MemberVO selectMemberById(SqlSession session, String id) throws SQLException;

	void updateMember(SqlSession session, MemberVO member) throws SQLException;
}
