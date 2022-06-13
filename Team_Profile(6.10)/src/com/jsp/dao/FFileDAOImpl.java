package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.FFileVO;

public class FFileDAOImpl implements FFileDAO{

	@Override
	public void insertFFile(SqlSession session,FFileVO fFile) throws SQLException {
		session.update("FFile-Mapper.insertFFile",fFile);
	}

	@Override
	public void deleteFFile(SqlSession session,int a_no) throws SQLException {
		session.update("FFile-Mapper.deleteFFile",a_no);		
		
	}

	@Override
	public List<FFileVO> selectFFilesByf_no(SqlSession session,int f_no) throws SQLException {
		List<FFileVO> fFileList=session.selectList("FFile-Mapper.selectFFileByf_no",f_no);
		return fFileList;
	}

	@Override
	public void deleteAllFFile(SqlSession session,int f_no) throws SQLException {
		session.update("FFile-Mapper.deleteAllFFile",f_no);		
	}
	
	@Override
	public FFileVO selectFFileBya_no(SqlSession session,int a_no) throws SQLException {
		FFileVO fFile=session.selectOne("FFile-Mapper.selectFFileBya_no",a_no);
		return fFile;
	}
}
