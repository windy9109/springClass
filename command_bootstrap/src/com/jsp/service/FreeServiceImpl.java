package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.FreeDAO;
import com.jsp.dao.NoticeDAO;
import com.jsp.dto.FreeVO;

public class FreeServiceImpl implements FreeService{
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	private FreeDAO freeDAO;
	public void setFreeDAO(FreeDAO freeDAO) {
		this.freeDAO = freeDAO;
	}



	@Override
	public Map<String, Object> getFreeList(Criteria cri) throws SQLException {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();

			// 현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
			List<FreeVO> FreeList = freeDAO.selectSearchFreeList(session, cri);

			// 전체 board 개수
			int totalCount = freeDAO.selectSearchFreeListCount(session, cri);

			// PageMaker 생성.
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(totalCount);

			dataMap.put("freeList", FreeList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
		} finally {
			session.close();
		}
	}

	@Override
	public FreeVO getFree(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			FreeVO board = freeDAO.selectFreeByBno(session, bno);
			freeDAO.increaseViewCount(session, bno);
			return board;
		} finally {
			session.close();
		}
	}

	@Override
	public FreeVO getFreeForModify(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			FreeVO board = freeDAO.selectFreeByBno(session, bno);
			return board;
		} finally {
			session.close();
		}
	}

	@Override
	public void regist(FreeVO Free) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			int nno = freeDAO.selectFreeSequenceNextValue(session);
			Free.setBno(nno);
			freeDAO.insertFree(session, Free);
		} finally {
			session.close();
		}
	}
	@Override
	public void modify(FreeVO Free) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			freeDAO.updateFree(session, Free);
		} finally {
			session.close();
		}
	}

	@Override
	public void remove(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			freeDAO.deleteFree(session, bno);
		} finally {
			session.close();
		}
	}
	
}
