package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.FreeVO;
import com.jsp.dto.NoticeVO;

public interface FreeService {
	

	// 목록조회
	Map<String, Object> getFreeList(Criteria cri) throws SQLException;
	
	// 상세보기
	FreeVO getFree(int nno) throws SQLException;
	
	// 수정화면 상세
	FreeVO getFreeForModify(int nno) throws SQLException;

	// 등록
	void regist(FreeVO notice)throws SQLException;
	
	// 수정
	void modify(FreeVO notice) throws SQLException;

	// 삭제
	void remove(int nno) throws SQLException;
}
