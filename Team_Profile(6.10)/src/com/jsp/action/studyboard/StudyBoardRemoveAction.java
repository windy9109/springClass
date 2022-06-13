package com.jsp.action.studyboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.StudyBoardService;

public class StudyBoardRemoveAction implements Action {

	private StudyBoardService studyboardService;
	public void setStudyBoardService(StudyBoardService studyboardService) {
		this.studyboardService = studyboardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="/studyboard/remove_success";
		try {
			int s_no = Integer.parseInt(request.getParameter("s_no"));
		
			studyboardService.remove(s_no);
		}catch(Exception e) {			
			url= null;
			e.printStackTrace();
			throw e;
		}
		
		
		return url;
	}

}
