package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.MeetingBoardVO;

public interface MeetingBoardService {
	// 목록조회	
		Map<String,Object> getMeetingBoardList(Criteria cri)throws SQLException;
		
		// 상세보기
		MeetingBoardVO getMeetingBoard(int m_no)throws SQLException;	
		MeetingBoardVO getMeetingBoardForModify(int m_no)throws SQLException;
			
		// 등록
		void regist(MeetingBoardVO meetingBoard)throws SQLException;
			
		// 수정
		void modify(MeetingBoardVO meetingBoard)throws SQLException;
		
		// 삭제
		void remove(int m_no)throws SQLException;
}
