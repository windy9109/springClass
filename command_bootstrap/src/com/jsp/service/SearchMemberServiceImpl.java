package com.jsp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.command.SearcjCriteria;
import com.jsp.dao.SearchMemberDAO;
import com.jsp.dao.SearchMemberDAOImpl;
import com.jsp.datasource.OracleMybatisSqlSessionFactory;
import com.jsp.dto.MemberVO;
import com.jsp.exception.NotMatchSearchCriteria;

public class SearchMemberServiceImpl extends MemberServiceImpl{

	private SqlSessionFactory sqlSessionFactory;
	private SearchMemberDAO memberDAO;

	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}


	public void setMemberDAO(SearchMemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}




	@Override
	public Map<String, Object> getMemberListforPage(Criteria cri) throws Exception {
		
		if(cri instanceof SearcjCriteria) {
			SearcjCriteria searchCri = (SearcjCriteria)cri;
			SqlSession session = sqlSessionFactory.openSession(false);
			Map<String, Object> dataMap = null;
			try {
				//처리.....
				//리스트가져오기
				List<MemberVO> memberList = memberDAO.selectMemberList(session, searchCri);
				PageMaker pageMaker = new PageMaker();
				pageMaker.setCri(cri);
				pageMaker.setTotalCount(memberDAO.selectSeachMemberListCount(session, searchCri));
				
				dataMap = new HashMap<String, Object>();
				dataMap.put("memberList", memberList);
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
		}else {
			throw new NotMatchSearchCriteria();
		}
		
	}
		

	
	
}
