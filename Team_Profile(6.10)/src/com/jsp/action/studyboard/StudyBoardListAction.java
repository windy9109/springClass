package com.jsp.action.studyboard;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.SearchCriteriaCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.service.StudyBoardService;

public class StudyBoardListAction implements Action {
	
	private StudyBoardService studyboardService;
	public void setStudyBoardService(StudyBoardService studyboardService) {
		this.studyboardService = studyboardService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String url = "/board/study/list";
		
		try {

			SearchCriteriaCommand criCMD
			=HttpRequestParameterAdapter.execute(request, SearchCriteriaCommand.class);
			
			Criteria cri = criCMD.toSearchCriteria();		
			
			Map<String, Object> dataMap = studyboardService.getStudyBoardList(cri);
			request.setAttribute("dataMap", dataMap);
		}catch (Exception e) {			
			e.printStackTrace();			
			//url="/error/500.jsp";
			throw e;
		}
		
		return url;
	}

}
