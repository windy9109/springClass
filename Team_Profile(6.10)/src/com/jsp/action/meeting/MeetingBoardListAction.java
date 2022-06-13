package com.jsp.action.meeting;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.SearchCriteriaCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.service.MeetingBoardService;

public class MeetingBoardListAction implements Action {
	
	private MeetingBoardService meetingBoardService;
	public void setMeetingBoardService(MeetingBoardService meetingBoardService) {
		this.meetingBoardService = meetingBoardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/meeting/list";
		try {
			SearchCriteriaCommand criCMD
			=HttpRequestParameterAdapter.execute(request, SearchCriteriaCommand.class);
			
			Criteria cri = criCMD.toSearchCriteria();		
			
			Map<String, Object> dataMap = meetingBoardService.getMeetingBoardList(cri);
			request.setAttribute("dataMap", dataMap);
		}catch (Exception e) {			
			e.printStackTrace();			
			//url="/error/500.jsp";
			throw e;
		}
		
		return url;
	}

}
