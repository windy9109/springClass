package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.StudyBoardVO;

public interface StudyBoardService {

	// 목록조회	
	Map<String,Object> getStudyBoardList(Criteria cri)throws SQLException;
	
	// 상세보기
	StudyBoardVO getStudyBoard(int s_no)throws SQLException;	
	StudyBoardVO getStudyBoardForModify(int s_no)throws SQLException;
		
	// 등록
	void regist(StudyBoardVO studyboard)throws SQLException;
		
	// 수정
	void modify(StudyBoardVO studyboard)throws SQLException;
	
	// 삭제
	void remove(int s_no)throws SQLException;
}
