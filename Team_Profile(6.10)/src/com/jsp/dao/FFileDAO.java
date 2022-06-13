package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.FFileVO;

public interface FFileDAO {

	public List<FFileVO> selectFFilesByf_no(SqlSession session, int f_no)throws SQLException;
	public FFileVO selectFFileBya_no(SqlSession session,int a_no)throws SQLException;
	
	public void insertFFile(SqlSession session,FFileVO fFile) throws SQLException;

	public void deleteFFile(SqlSession session,int a_no) throws SQLException;

	public void deleteAllFFile(SqlSession session,int f_no)throws SQLException;
}