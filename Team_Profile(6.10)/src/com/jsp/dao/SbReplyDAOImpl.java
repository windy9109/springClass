package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.SbReplyVO;

public class SbReplyDAOImpl implements SbReplyDAO {

	@Override
	public void insertSbReply(SqlSession session, SbReplyVO sbreply) throws SQLException {
		session.update("SbReply-Mapper.insertSbReply",sbreply);

	}

	@Override
	public void updatSbReply(SqlSession session, SbReplyVO sbreply) throws SQLException {
		session.update("SbReply-Mapper.updatSbReply",sbreply);

	}

	@Override
	public void deleteSbReply(SqlSession session, int sb_rno) throws SQLException {
		session.update("SbReply-Mapper.deleteSbReply",sb_rno);

	}

	@Override
	public int selectSbReplySeqNextValue(SqlSession session) throws SQLException {
		int sb_rno=(Integer)session.selectOne("SbReply-Mapper.selectSbReplySeqNextValue");
		return sb_rno;
	}

	@Override
	public List<SbReplyVO> selectSbReplyListPage(SqlSession session, int sb_no, Criteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds=new RowBounds(offset,limit);
		
		List<SbReplyVO> sbreplyList=session.selectList("SbReply-Mapper.selectSbReplyListPage",sb_no,rowBounds);
		return sbreplyList;
	}

	@Override
	public int countSbReply(SqlSession session, int sb_no) throws SQLException {
		int count=session.selectOne("SbReply-Mapper.countSbReply",sb_no);
		return count;
	}

}
