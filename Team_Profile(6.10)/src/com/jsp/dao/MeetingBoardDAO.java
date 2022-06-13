package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.MeetingBoardVO;

public interface MeetingBoardDAO {
	
	List<MeetingBoardVO> selectMeetingBoardCriteria(SqlSession session,Criteria cri) throws SQLException;

	int selectMeetingBoardCriteriaTotalCount(SqlSession session,Criteria cri) throws SQLException;

	MeetingBoardVO selectMeetingBoardByMno(SqlSession session,int m_no) throws SQLException;

	void insertMeetingBoard(SqlSession session,MeetingBoardVO meetingBoard) throws SQLException;

	void updateMeetingBoard(SqlSession session,MeetingBoardVO meetingBoard) throws SQLException;

	void deleteMeetingBoard(SqlSession session,int m_no) throws SQLException;

	// viewcnt 증가
	void increaseViewCnt(SqlSession session,int m_no) throws SQLException;

	// board_seq.nextval 가져오기
	int selectMeetingBoardSeqNext(SqlSession session) throws SQLException;
	
}
