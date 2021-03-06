package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.MeetingBoardDAO;
import com.jsp.dto.MeetingBoardVO;

public class MeetingBoardServiceImpl implements MeetingBoardService {
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	private MeetingBoardDAO meetingBoardDAO;
	public void setMeetingBoardDAO(MeetingBoardDAO meetingBoardDAO) {
		this.meetingBoardDAO = meetingBoardDAO;
	}
	
	@Override
	public MeetingBoardVO getMeetingBoardForModify(int m_no) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			MeetingBoardVO meetingBoard = meetingBoardDAO.selectMeetingBoardByMno(session, m_no);
			return meetingBoard;
		} finally {
			session.close();
		}
	}

	@Override
	public MeetingBoardVO getMeetingBoard(int m_no) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			MeetingBoardVO meetingBoard = meetingBoardDAO.selectMeetingBoardByMno(session, m_no);
			meetingBoardDAO.increaseViewCnt(session, m_no);
			return meetingBoard;
		} finally {
			session.close();
		}
	}

	@Override
	public void regist(MeetingBoardVO meetingBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			int m_no = meetingBoardDAO.selectMeetingBoardSeqNext(session);

			meetingBoard.setM_no(m_no);

			meetingBoardDAO.insertMeetingBoard(session, meetingBoard);
		} finally {
			session.close();
		}
	}

	@Override
	public void modify(MeetingBoardVO meetingBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			meetingBoardDAO.updateMeetingBoard(session, meetingBoard);
		} finally {
			session.close();
		}
	}

	@Override
	public void remove(int m_no) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			meetingBoardDAO.deleteMeetingBoard(session, m_no);
		} finally {
			session.close();
		}
	}

	@Override
	public Map<String, Object> getMeetingBoardList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();

			// ?????? page ????????? ?????? ???????????? perPageNum ?????? ?????? ????????????.
			List<MeetingBoardVO> meetingBoardList = meetingBoardDAO.selectMeetingBoardCriteria(session, cri);
						
			// ?????? board ??????
			int totalCount = meetingBoardDAO.selectMeetingBoardCriteriaTotalCount(session, cri);

			// PageMaker ??????.
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(totalCount);

			dataMap.put("meetingBoardList", meetingBoardList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
		} finally {
			session.close();
		}
	}
}
