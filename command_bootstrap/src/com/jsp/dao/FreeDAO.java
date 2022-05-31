package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.FreeVO;
import com.jsp.dto.NoticeVO;

public interface FreeDAO {
	

	List<FreeVO> selectSearchFreeList(SqlSession session,Criteria cri) 
				throws SQLException;

	int selectSearchFreeListCount(SqlSession session,Criteria cri) 
				throws SQLException;
	
	FreeVO selectFreeByBno(SqlSession session,int bno) throws SQLException;
	
	// viewcnt 증가
	void increaseViewCount(SqlSession session,int bno) throws SQLException;

	// Notice_seq.nextval 가져오기
	int selectFreeSequenceNextValue(SqlSession session) throws SQLException;
	
	void insertFree(SqlSession session,FreeVO Free) throws SQLException;
	
	void updateFree(SqlSession session,FreeVO Free) throws SQLException;

	void deleteFree(SqlSession session,int bno) throws SQLException;
}
