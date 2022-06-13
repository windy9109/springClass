package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.NoticeBoardVO;

public interface NoticeService {
	// 목록조회
	Map<String, Object> getNoticeList(Criteria cri) throws SQLException;
	
	// 상세보기
	NoticeBoardVO getNotice(int i_no) throws SQLException;
	
	// 수정화면 상세
	NoticeBoardVO getNoticeForModify(int i_no) throws SQLException;

	// 등록
	void regist(NoticeBoardVO notice)throws SQLException;
	
	// 수정
	void modify(NoticeBoardVO notice) throws SQLException;

	// 삭제
	void remove(int i_no) throws SQLException;
}
