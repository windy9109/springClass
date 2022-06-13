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
import com.jsp.dto.MemberVO;
import com.jsp.dto.SbReplyVO;

public class SbReplyServiceImpl implements SbReplyService {

	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	private SbReplyDAO sbreplyDAO;
	public void setSbreplyDAO(SbReplyDAO sbreplyDAO) {
		this.sbreplyDAO = sbreplyDAO;
	}
	
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public Map<String, Object> getSbReplyList(int sb_no, Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		try {
			List<SbReplyVO> sbreplyList = sbreplyDAO.selectSbReplyListPage(session, sb_no, cri);
			
			if(sbreplyList != null) for(SbReplyVO sbreply : sbreplyList) {
				MemberVO member = memberDAO.selectMemberById(session, sbreply.getSb_rmem());
				sbreply.setPicture(member.getPicture());
			}
			
			int count = sbreplyDAO.countSbReply(session, sb_no);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(count);
	
			dataMap.put("sbreplyList", sbreplyList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
			
		}finally{
			session.close();
		}
	}

	@Override
	public int getSbReplyListCount(int sb_no) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int count = sbreplyDAO.countSbReply(session, sb_no);
			return count;
		} finally {
			session.close();
		}
	}

	@Override
	public void registSbReply(SbReplyVO sbreply) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int sb_rno = sbreplyDAO.selectSbReplySeqNextValue(session);
			sbreply.setSb_rno(sb_rno);

			sbreplyDAO.insertSbReply(session,sbreply);
		} finally {
			session.close();
		}

	}

	@Override
	public void modifySbReply(SbReplyVO sbreply) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			sbreplyDAO.updatSbReply(session, sbreply);
		} finally {
			session.close();
		}	

	}

	@Override
	public void removeSbReply(int sb_rno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			sbreplyDAO.deleteSbReply(session, sb_rno);
		} finally {
			session.close();
		}

	}

}
