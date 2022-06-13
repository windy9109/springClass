package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.command.SearchCriteria;
import com.jsp.dto.MeetingBoardVO;

public class MeetingBoardDAOImpl implements MeetingBoardDAO {

	@Override
	public List<MeetingBoardVO> selectMeetingBoardCriteria(SqlSession session,Criteria cri) throws SQLException {
		
		SearchCriteria searchCri = (SearchCriteria)cri;
		int offset=cri.getStartRowNum();
		int limit=cri.getPerPageNum();		
		RowBounds rowBounds=new RowBounds(offset,limit);		
		
		List<MeetingBoardVO> boardList=
				session.selectList("MeetingBoard-Mapper.selectSearchMeetingBoardList",searchCri,rowBounds);
		
		return boardList;
	}
	
	@Override
	public int selectMeetingBoardCriteriaTotalCount(SqlSession session,Criteria cri) throws SQLException {
		
		SearchCriteria searchCri = (SearchCriteria)cri;
		int count=session.selectOne("MeetingBoard-Mapper.selectSearchMeetingBoardListCount",searchCri);
		return count;
	}
	
	@Override
	public MeetingBoardVO selectMeetingBoardByMno(SqlSession session,int m_no) throws SQLException {
		MeetingBoardVO board=session.selectOne("MeetingBoard-Mapper.selectMeetingBoardBym_no",m_no);
		return board;
	}

	@Override
	public void insertMeetingBoard(SqlSession session,MeetingBoardVO board) throws SQLException {
		session.update("MeetingBoard-Mapper.insertMeetingBoard",board);
	}

	@Override
	public void updateMeetingBoard(SqlSession session,MeetingBoardVO board) throws SQLException {
		session.update("MeetingBoard-Mapper.updateMeetingBoard",board);
	}

	@Override
	public void deleteMeetingBoard(SqlSession session,int m_no) throws SQLException {
		session.update("MeetingBoard-Mapper.deleteMeetingBoard",m_no);
	}

	@Override
	public void increaseViewCnt(SqlSession session,int m_no) throws SQLException {
		session.update("MeetingBoard-Mapper.increaseViewCnt",m_no);
	}

	@Override
	public int selectMeetingBoardSeqNext(SqlSession session) throws SQLException {
		int seq_num=session.selectOne("MeetingBoard-Mapper.selectMeetingBoardSeqNext");
		return seq_num;
	}
}
