package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.command.SearchCriteria;
import com.jsp.dto.StudyBoardVO;

public class StudyBoardDAOImpl implements StudyBoardDAO {

	@Override
	public List<StudyBoardVO> selectStudyBoardCriteria(SqlSession session, Criteria cri) throws SQLException {
		SearchCriteria searchCri = (SearchCriteria)cri;
		int offset=cri.getStartRowNum();
		int limit=cri.getPerPageNum();		
		RowBounds rowBounds=new RowBounds(offset,limit);		
		
		List<StudyBoardVO> studyboardList=
				session.selectList("StudyBoard-Mapper.selectSearchStudyBoardList",searchCri,rowBounds);
		
		return studyboardList;
	}

	@Override
	public int selectStudyBoardCriteriaTotalCount(SqlSession session, Criteria cri) throws SQLException {
		SearchCriteria searchCri = (SearchCriteria)cri;
		int count=session.selectOne("StudyBoard-Mapper.selectSearchStudyBoardListCount",searchCri);
		return count;
	}

	@Override
	public StudyBoardVO selectStudyBoardBySno(SqlSession session, int s_no) throws SQLException {
		StudyBoardVO studyboard=
				session.selectOne("StudyBoard-Mapper.selectStudyBoardBySno",s_no);
		return studyboard;
	}

	@Override
	public void insertStudyBoard(SqlSession session, StudyBoardVO studyboard) throws SQLException {
		session.update("StudyBoard-Mapper.insertStudyBoard",studyboard);

	}

	@Override
	public void updateStudyBoard(SqlSession session, StudyBoardVO studyboard) throws SQLException {
		session.update("StudyBoard-Mapper.updateStudyBoard",studyboard);

	}

	@Override
	public void deleteStudyBoard(SqlSession session, int s_no) throws SQLException {
		session.update("StudyBoard-Mapper.deleteStudyBoard",s_no);
	}

	@Override
	public void increaseViewCnt(SqlSession session, int s_no) throws SQLException {
		session.update("StudyBoard-Mapper.increaseViewCnt",s_no);

	}

	@Override
	public int selectStudyBoardSeqNext(SqlSession session) throws SQLException {
		int seq_num=
				session.selectOne("StudyBoard-Mapper.selectStudyBoardSeqNext");
		return seq_num;
	}

}
