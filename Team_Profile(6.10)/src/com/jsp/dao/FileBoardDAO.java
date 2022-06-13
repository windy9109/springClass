package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.FileBoardVO;

public interface FileBoardDAO {
	

	List<FileBoardVO> selectFileBoardList(SqlSession session,Criteria cri)	throws SQLException;
	int selectFileBoardCount(SqlSession session,Criteria cri) throws SQLException;
	
	FileBoardVO selectFileBoardByf_no(SqlSession session,int f_no)throws SQLException;
	
	void insertFileBoard(SqlSession session,FileBoardVO fileBoard)throws SQLException;
	void updateFileBoard(SqlSession session,FileBoardVO fileBoard)throws SQLException;
	void deleteFileBoard(SqlSession session,int f_no)throws SQLException;
	
	//fileBoard_seq.nextval 가져오기
	int getSeqNextValue(SqlSession session) throws SQLException;
}
