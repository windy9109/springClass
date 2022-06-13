package com.jsp.action.studyboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.StudyBoardModifyCommand;
import com.jsp.controller.XSSHttpRequestParameterAdapter;
import com.jsp.dto.StudyBoardVO;
import com.jsp.service.StudyBoardService;

public class StudyBoardModifyAction implements Action {

	private StudyBoardService studyboardService;
	public void setStudyBoardService(StudyBoardService studyboardService) {
		this.studyboardService = studyboardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "redirect:/studyboard/detail.do?from=modify&s_no="+request.getParameter("s_no");
		
		try {
		StudyBoardModifyCommand modifyReq 
		= (StudyBoardModifyCommand)XSSHttpRequestParameterAdapter.execute(request, StudyBoardModifyCommand.class, true);
		
		StudyBoardVO studyboard = modifyReq.toStudyBoardVO();
		studyboard.setS_content(request.getParameter("s_content"));
		
		studyboardService.modify(studyboard);
		}catch(Exception e) {
			e.printStackTrace();
			url = null;
			throw e;
		}			
		
		return url;
	}

}
