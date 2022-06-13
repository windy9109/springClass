package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.SbReplyVO;

public interface SbReplyService {
	// 리스트 보기
	Map<String, Object> getSbReplyList(int sb_no, Criteria cri) throws SQLException;
	
	// 리스트 개수
	int getSbReplyListCount(int sb_no) throws SQLException;
	
	// 등록
	void registSbReply(SbReplyVO sbreply) throws SQLException;
	
	// 수정
	void modifySbReply(SbReplyVO sbreply) throws SQLException;
	
	// 삭제
	void removeSbReply(int sb_rno) throws SQLException;
}
