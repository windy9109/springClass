package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.SbReplyVO;

public interface SbReplyDAO {
	void insertSbReply(SqlSession session, SbReplyVO sbreply) throws SQLException;
	void updatSbReply(SqlSession session, SbReplyVO sbreply) throws SQLException;
	void deleteSbReply(SqlSession session, int sb_rno) throws SQLException;
	
	int selectSbReplySeqNextValue(SqlSession session) throws SQLException;
	List<SbReplyVO> selectSbReplyListPage(SqlSession session, int sb_no, Criteria cri) throws SQLException;
	
	int countSbReply(SqlSession session, int sb_no) throws SQLException;
}
