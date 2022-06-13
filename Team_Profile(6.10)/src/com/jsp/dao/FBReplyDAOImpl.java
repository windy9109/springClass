package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.FBReplyVO;

public class FBReplyDAOImpl implements FBReplyDAO {

	@Override
	public void insertFBReply(SqlSession session, FBReplyVO fbreply) throws SQLException {
		session.update("FBReply-Mapper.insertFBReply",fbreply);
		
	}

	@Override
	public void updateFBReply(SqlSession session, FBReplyVO fbreply) throws SQLException {
		session.update("FBReply-Mapper.updateFBReply",fbreply);
		
	}

	@Override
	public void deleteFBReply(SqlSession session, int fb_rno) throws SQLException {
		session.update("FBReply-Mapper.deleteFBReply",fb_rno);
		
	}

	@Override
	public int selectFBReplySeqNextValue(SqlSession session) throws SQLException {
		int fb_rno=(Integer)session.selectOne("FBReply-Mapper.selectFBReplySeqNextValue");
		return fb_rno;
	}

	@Override
	public List<FBReplyVO> selectFBReplyList(SqlSession session, int fb_no, Criteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit =cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<FBReplyVO> replyList = session.selectList("FBReply-Mapper.selectFBReplyList",fb_no,rowBounds);
		return replyList;
	}

	@Override
	public int countFBReply(SqlSession session, int fb_no) throws SQLException {
		int count = session.selectOne("FBReply-Mapper.countFBReply", fb_no);
		return count;
	}

}
