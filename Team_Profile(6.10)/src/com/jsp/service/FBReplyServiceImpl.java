package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.FBReplyDAO;
import com.jsp.dto.FBReplyVO;

public class FBReplyServiceImpl implements FBReplyService {
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	private FBReplyDAO fbreplyDAO;
	public void setFBReplyDAO(FBReplyDAO fbreplyDAO) {
		this.fbreplyDAO = fbreplyDAO;
	}
	
//	private MemberDAO memberDAO;
//	public void setMemberDAO(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}

	@Override
	public Map<String, Object> getFBReplyList(int fb_no, Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		try {
			List<FBReplyVO> replyList = fbreplyDAO.selectFBReplyList(session, fb_no, cri);
			
//			if(replyList != null) for(FBReplyVO reply : replyList) {
//				MemberVO member = memberDAO.selectMemberById(session, reply.getFb_replyer());
//				reply.setFb_picture(member.getPicture());
//			}
			
			int count = fbreplyDAO.countFBReply(session, fb_no);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(count);
			
			dataMap.put("replyList",replyList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
		} finally {
			session.close();
		}
	}

	@Override
	public int getFBReplyListCount(int fb_no) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int count = fbreplyDAO.countFBReply(session, fb_no);
			return count;
		} finally {
			session.close();
			// TODO: handle finally clause
		}
	}

	@Override
	public void registFBReply(FBReplyVO fbreply) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int fb_rno = fbreplyDAO.selectFBReplySeqNextValue(session);
			fbreply.setFb_rno(fb_rno);

			fbreplyDAO.insertFBReply(session, fbreply);
		} finally {
			session.close();
		}
	}

	@Override
	public void modifyFBReply(FBReplyVO fbreply) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			fbreplyDAO.updateFBReply(session, fbreply);
		} finally {
			session.close();
		}
	}

	@Override
	public void removeFBReply(int fb_rno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			fbreplyDAO.deleteFBReply(session, fb_rno);
		} finally {
			session.close();
		}
	}

}
