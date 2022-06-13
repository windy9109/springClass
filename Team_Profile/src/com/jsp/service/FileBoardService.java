package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.FFileVO;
import com.jsp.dto.FileBoardVO;

public interface FileBoardService {
	

	// 리스트조회
	Map<String, Object> getFileBoardList(Criteria cri) throws SQLException;

	// 글조회
	FileBoardVO getFileBoard(int f_no) throws SQLException;

	// 글작성
	void regist(FileBoardVO fileBoard) throws SQLException;

	// 글수정
	void modify(FileBoardVO fileBoard) throws SQLException;

	// 글삭제
	void remove(int f_no) throws SQLException;
		
	//첨부파일 조회
	FFileVO getFFileBya_no(int a_no)throws SQLException;
	
	//파일정보 삭제
	void removeFFileBya_no(int a_no)throws SQLException;

}








