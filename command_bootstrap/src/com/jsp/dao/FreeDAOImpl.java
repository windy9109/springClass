package com.jsp.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.command.SearchCriteria;
import com.jsp.dto.FreeVO;
import com.jsp.dto.NoticeVO;

public class FreeDAOImpl implements FreeDAO {

	@Override
	public List<FreeVO> selectSearchFreeList(SqlSession session, Criteria cri) throws SQLException {

		int startRow = cri.getStartRowNum();
		int endRow = startRow+cri.getPerPageNum()-1;

		SearchCriteria searchCri = (SearchCriteria)cri;
		
		Map<String, Object> dataParam = new HashMap<String, Object>();
		dataParam.put("startRow", startRow);
		dataParam.put("endRow", endRow);
		dataParam.put("searchType", searchCri.getSearchType());
		dataParam.put("keyword", searchCri.getKeyword());

		List<FreeVO> freeList = session.selectList("Free-Mapper.selectSearchFreeList", dataParam);

		return freeList;
	}

	@Override
	public int selectSearchFreeListCount(SqlSession session, Criteria cri) throws SQLException {
		int count = session.selectOne("Free-Mapper.selectSearchFreeListCount", cri);
		return count;
	}

	@Override
	public FreeVO selectFreeByBno(SqlSession session, int bno) throws SQLException {
		FreeVO free = session.selectOne("Free-Mapper.selectFreeByBno", bno);
		return free;
	}

	@Override
	public void increaseViewCount(SqlSession session, int bno) throws SQLException {
		session.update("Free-Mapper.increaseViewCount", bno);

	}

	@Override
	public int selectFreeSequenceNextValue(SqlSession session) throws SQLException {
		int seq_num = session.selectOne("Free-Mapper.selectFreeSequenceNextValue");
		return seq_num;
	}

	@Override
	public void insertFree(SqlSession session, FreeVO Free) throws SQLException {
		session.update("Free-Mapper.insertFree", Free);

	}

	@Override
	public void updateFree(SqlSession session, FreeVO Free) throws SQLException {
		session.update("Free-Mapper.updateFree", Free);
	}

	@Override
	public void deleteFree(SqlSession session, int bno) throws SQLException {
		session.update("Free-Mapper.deleteFree", bno);
	}
}
