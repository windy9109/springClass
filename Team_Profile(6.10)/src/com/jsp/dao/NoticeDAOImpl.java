package com.jsp.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.command.SearchCriteria;
import com.jsp.dto.NoticeBoardVO;

public class NoticeDAOImpl implements NoticeDAO {

	@Override
	public List<NoticeBoardVO> selectSearchNoticeList(SqlSession session, Criteria cri) throws SQLException {

	      int startRow = cri.getStartRowNum();
	      int endRow = startRow + cri.getPerPageNum() -1;

	      SearchCriteria searchCri = (SearchCriteria) cri;

	      Map<String, Object> dataParam = new HashMap<String, Object>();
	      dataParam.put("startRow", startRow);
	      dataParam.put("endRow", endRow);
	      dataParam.put("searchType", searchCri.getSearchType());
	      dataParam.put("keyword", searchCri.getKeyword());

	      List<NoticeBoardVO> noticeList = session.selectList("Notice-Mapper.selectSearchNoticeList", dataParam);

	      return noticeList;
	}

	@Override
	public int selectSearchNoticeListCount(SqlSession session, Criteria cri) throws SQLException {
	      int count = session.selectOne("Notice-Mapper.selectSearchNoticeListCount", cri);
	      return count;
	}

	@Override
	public NoticeBoardVO selectNoticeByIno(SqlSession session, int i_no) throws SQLException {
	      NoticeBoardVO notice = session.selectOne("Notice-Mapper.selectNoticeByIno", i_no);
	      return notice;
	}

	@Override
	public void increaseViewCount(SqlSession session, int i_no) throws SQLException {
		session.update("Notice-Mapper.increaseViewCount", i_no);

	}

	@Override
	public int selectNoticeSequenceNextValue(SqlSession session) throws SQLException {
		 int seq_num = session.selectOne("Notice-Mapper.selectNoticeSequenceNextValue");
	     return seq_num;
	}

	@Override
	public void insertNotice(SqlSession session, NoticeBoardVO notice) throws SQLException {
		session.update("Notice-Mapper.insertNotice", notice);

	}

	@Override
	public void updateNotice(SqlSession session, NoticeBoardVO notice) throws SQLException {
	      session.update("Notice-Mapper.updateNotice", notice);

	}

	@Override
	public void deleteNotice(SqlSession session, int i_no) throws SQLException {
	      session.update("Notice-Mapper.deleteNotice", i_no);

	}

}
