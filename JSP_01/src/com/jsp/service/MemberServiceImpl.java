package com.jsp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.MemberDAO;
import com.jsp.dao.MemberDAOImpl;
import com.jsp.datasource.OracleMybatisSqlSessionFactory;
import com.jsp.vo.BoardVO;


public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO = new MemberDAOImpl();
	
	private OracleMybatisSqlSessionFactory sqlSessionFactory =
			new OracleMybatisSqlSessionFactory();
	
	@Override
	public List<BoardVO> getMemberList() throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		List<BoardVO> boardList= null;
		try {
			boardList = memberDAO.selectMemberList(session);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw e;
		}
		finally {
			if(session != null)session.close();
		}
		return boardList;
	}

	@Override
	public List<BoardVO> getMemberList(Criteria cri) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		List<BoardVO> boardList= null;
		try {
			boardList = memberDAO.selectMemberList(session, cri);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw e;
		}
		finally {
			if(session != null)session.close();
		}
		return boardList;
	}

	@Override
	public Map<String, Object> getMemberListforPage(Criteria cri) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		Map<String, Object> dataMap = null;
		try {
			//처리.....
			//리스트가져오기
			List<BoardVO> boardList = memberDAO.selectMemberList(session, cri);
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(memberDAO.selectMemberListCount(session));
			
			dataMap = new HashMap<String, Object>();
			dataMap.put("boardList", boardList);
			dataMap.put("pageMaker", pageMaker);
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw e;
		}
		finally {
			if(session != null)session.close();
		}
		return dataMap;
	}

}
