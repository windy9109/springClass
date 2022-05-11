package com.jsp.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.vo.BoardVO;



public class MemberDAOImpl implements MemberDAO {

	@Override
	public List<BoardVO> selectMemberList(SqlSession session)throws Exception {
		List<BoardVO>memberList = null;
		try {
			memberList = session.selectList("Member-Mapper.selectboardList");
		} catch (Exception e) {
			//에러처리
			throw e;
		}
		return memberList;
	}

	@Override
	public List<BoardVO> selectMemberList(SqlSession session, Criteria cri) throws Exception {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		List<BoardVO>memberList = session.selectList("Member-Mapper.selectboardList", null, rowBounds);
		
		return memberList;
	}

//	@Override
//	public int insert(SqlSession session) throws Exception {
//		int count = 0;
//		try {
//			count = session.selectList("Member-Mapper.selectboardList");
//		} catch (Exception e) {
//			//에러처리
//			throw e;
//		}
//		return count;
//	}

}
