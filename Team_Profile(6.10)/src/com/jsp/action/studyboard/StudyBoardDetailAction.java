package com.jsp.action.studyboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.StudyBoardVO;
import com.jsp.service.StudyBoardService;

public class StudyBoardDetailAction implements Action {

	private StudyBoardService studyboardService;
	public void setStudyBoardService(StudyBoardService studyboardService) {
		this.studyboardService = studyboardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/study/detail";

		try {
			int s_no = Integer.parseInt(request.getParameter("s_no"));
			
			StudyBoardVO studyboard =studyboardService.getStudyBoardForModify(s_no);
			

			request.setAttribute("studyboard", studyboard);
		} catch (Exception e) {
			e.printStackTrace();
			url = null;
			throw e;
		}

		return url;
	}
}
