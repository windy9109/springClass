package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.MemberDAO;
import com.jsp.dao.SbReplyDAO;
import com.jsp.dao.StudyBoardDAO;
import com.jsp.dto.MemberVO;
import com.jsp.dto.SbReplyVO;
import com.jsp.dto.StudyBoardVO;

public class StudyBoardServiceImpl implements StudyBoardService {
	
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	private StudyBoardDAO studyBoardDAO;
	public void setStudyBoardDAO(StudyBoardDAO studyBoardDAO){
		this.studyBoardDAO = studyBoardDAO;
	}
	
	private SbReplyDAO sbReplyDAO;
	public void setSbReplyDAO(SbReplyDAO sbReplyDAO) {
		this.sbReplyDAO = sbReplyDAO;
	}
	
	//private MemberDAO memberDAO;
	//public void setMemberDAO(MemberDAO memberDAO) {
	//	this.memberDAO = memberDAO;
	//}
	
	@Override
	public Map<String, Object> getStudyBoardList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			Map<String, Object> dataMap = new HashMap<String, Object>();

			// 현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
			List<StudyBoardVO> studyboardList = studyBoardDAO.selectStudyBoardCriteria(session, cri);
			
					
			// reply count 입력
			if(studyboardList != null) for (StudyBoardVO studyBoard : studyboardList) {
				int sbreplycnt = sbReplyDAO.countSbReply(session, studyBoard.getS_no());
				studyBoard.setSbreplycnt(sbreplycnt);
			}
		
			// 전체 board 개수
			int totalCount = studyBoardDAO.selectStudyBoardCriteriaTotalCount(session, cri);

			// PageMaker 생성.
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(totalCount);

			dataMap.put("studyboardList", studyboardList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
		} finally {
			session.close();
		}
	}

	@Override
	public StudyBoardVO getStudyBoard(int s_no) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StudyBoardVO studyboard = studyBoardDAO.selectStudyBoardBySno(session, s_no);
			studyBoardDAO.increaseViewCnt(session, s_no);
			return studyboard;
		} finally {
			session.close();
		}
	}

	@Override
	public StudyBoardVO getStudyBoardForModify(int s_no) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StudyBoardVO studyboard = studyBoardDAO.selectStudyBoardBySno(session, s_no);
			return studyboard;
		} finally {
			session.close();
		}
	}

	@Override
	public void regist(StudyBoardVO studyboard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			int s_no = studyBoardDAO.selectStudyBoardSeqNext(session);

			studyboard.setS_no(s_no);

			studyBoardDAO.insertStudyBoard(session, studyboard);
		} finally {
			session.close();
		}

	}

	@Override
	public void modify(StudyBoardVO studyboard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			studyBoardDAO.updateStudyBoard(session, studyboard);
		} finally {
			session.close();
		}

	}

	@Override
	public void remove(int s_no) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			studyBoardDAO.deleteStudyBoard(session, s_no);
		} finally {
			session.close();
		}

	}

}
