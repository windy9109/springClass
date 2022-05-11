package com.jsp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.vo.BoardVO;




public interface MemberDAO {

	
	List<BoardVO> selectMemberList(SqlSession session)throws Exception;
	List<BoardVO> selectMemberList(SqlSession session, Criteria cri)throws Exception;
	
//	int insert(SqlSession session)throws Exception;
	
}
