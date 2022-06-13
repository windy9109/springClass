package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.NoticeBoardVO;

public interface NoticeDAO {

	List<NoticeBoardVO> selectSearchNoticeList(SqlSession session,Criteria cri) 
				throws SQLException;

	int selectSearchNoticeListCount(SqlSession session,Criteria cri) 
				throws SQLException;
	
	NoticeBoardVO selectNoticeByIno(SqlSession session,int i_no) throws SQLException;
	
	// viewcnt 증가
	void increaseViewCount(SqlSession session,int i_no) throws SQLException;

	// Notice_seq.nextval 가져오기
	int selectNoticeSequenceNextValue(SqlSession session) throws SQLException;
	
	void insertNotice(SqlSession session,NoticeBoardVO notice) throws SQLException;
	
	void updateNotice(SqlSession session,NoticeBoardVO notice) throws SQLException;

	void deleteNotice(SqlSession session,int i_no) throws SQLException;
}
