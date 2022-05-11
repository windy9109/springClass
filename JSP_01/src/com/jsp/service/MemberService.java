package com.jsp.service;

import java.util.List;

import com.jsp.command.Criteria;
import com.jsp.vo.BoardVO;

public interface MemberService {
	List<BoardVO> getMemberList()throws Exception;
	List<BoardVO> getMemberList(Criteria cri)throws Exception;
	
}
