package com.jsp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.MemberVO;

public interface MemberDAO {

	//회원리스트조회
	List<MemberVO> selectMemberList(SqlSession session)throws Exception;
	List<MemberVO> selectMemberList(SqlSession session, Criteria cri)throws Exception;
	
	//일반리스트 전체개수
	int selectMemberListCount(SqlSession session)throws Exception;
}
