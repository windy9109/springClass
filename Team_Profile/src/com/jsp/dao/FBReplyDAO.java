package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.FBReplyVO;

public interface FBReplyDAO {
	
	void insertFBReply(SqlSession session,FBReplyVO fbreply) throws SQLException;
	void updateFBReply(SqlSession session,FBReplyVO fbreply) throws SQLException;
	void deleteFBReply(SqlSession session,int fb_rno) throws SQLException;
	
	int selectFBReplySeqNextValue(SqlSession session) throws SQLException;
	List<FBReplyVO> selectFBReplyList(SqlSession session,int fb_no,Criteria cri) throws SQLException;
	
	int countFBReply(SqlSession session,int fb_no) throws SQLException;
}
