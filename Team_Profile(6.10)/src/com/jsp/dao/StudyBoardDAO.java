package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.StudyBoardVO;

public interface StudyBoardDAO {

	List<StudyBoardVO> selectStudyBoardCriteria(SqlSession session,Criteria cri) throws SQLException;

	int selectStudyBoardCriteriaTotalCount(SqlSession session,Criteria cri) throws SQLException;

	StudyBoardVO selectStudyBoardBySno(SqlSession session,int s_no) throws SQLException;

	void insertStudyBoard(SqlSession session,StudyBoardVO studyboard) throws SQLException;

	void updateStudyBoard(SqlSession session,StudyBoardVO studyboard) throws SQLException;

	void deleteStudyBoard(SqlSession session,int s_no) throws SQLException;

	// viewcnt 증가
	void increaseViewCnt(SqlSession session,int s_no) throws SQLException;

	// board_seq.nextval 가져오기
	int selectStudyBoardSeqNext(SqlSession session) throws SQLException;
}
