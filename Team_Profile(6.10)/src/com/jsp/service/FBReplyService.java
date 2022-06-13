package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.FBReplyVO;

public interface FBReplyService {
	//리스트 보기
	Map<String, Object> getFBReplyList(int fb_no,Criteria cri) throws SQLException;
	
	//리스트 개수
	int getFBReplyListCount(int fb_no)throws SQLException;
	
	//등록
	void registFBReply(FBReplyVO fbreply) throws SQLException;
	
	//수정
	void modifyFBReply(FBReplyVO fbreply) throws SQLException;
	
	//삭제
	void removeFBReply(int fb_rno) throws SQLException;
}
