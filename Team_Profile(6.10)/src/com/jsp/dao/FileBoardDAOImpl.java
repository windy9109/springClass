package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.command.SearchCriteria;
import com.jsp.dto.FileBoardVO;

public class FileBoardDAOImpl implements FileBoardDAO{
	

	@Override
	public List<FileBoardVO> selectFileBoardList(SqlSession session,Criteria cri) throws SQLException {
		
		SearchCriteria searchCri = (SearchCriteria)cri;
		
		int offset=cri.getStartRowNum();
		int limit=cri.getPerPageNum();
		RowBounds rowBounds=new RowBounds(offset,limit);
		
		List<FileBoardVO> fileBoardList=
		   session.selectList("FileBoard-Mapper.selectSearchFileBoardList",searchCri,rowBounds);	
			
		return fileBoardList;
	}

	@Override
	public int selectFileBoardCount(SqlSession session,Criteria cri) throws SQLException {
		SearchCriteria searchCri = (SearchCriteria)cri;
		int count=session.selectOne("FileBoard-Mapper.selectSearchFileBoardListCount",searchCri);
		return count;
	}

	@Override
	public FileBoardVO selectFileBoardByf_no(SqlSession session,int f_no) throws SQLException {
		FileBoardVO fileBoard=session.selectOne("FileBoard-Mapper.selectFileBoardByf_no",f_no);
		return fileBoard;
	}

	@Override
	public void insertFileBoard(SqlSession session,FileBoardVO fileBaord) throws SQLException {
		session.update("FileBoard-Mapper.insertFileBoard",fileBaord);
	}

	@Override
	public void updateFileBoard(SqlSession session,FileBoardVO fileBaord) throws SQLException {
		session.update("FileBoard-Mapper.updateFileBoard",fileBaord);
	}

	@Override
	public void deleteFileBoard(SqlSession session,int f_no) throws SQLException {
		session.update("FileBoard-Mapper.deleteFileBoard",f_no);
	}

	@Override
	public int getSeqNextValue(SqlSession session) throws SQLException {
		int f_no=session.selectOne("FileBoard-Mapper.selectFileBoardSeqNext");
		return f_no;
	}
}
