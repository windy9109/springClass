package com.jsp.action.meeting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.XSSHttpRequestParameterAdapter;
import com.jsp.dto.DateBoardVO;
import com.jsp.dto.MeetingBoardVO;
import com.jsp.service.MeetingBoardService;

public class MeetingBoardRegistAction implements Action {
	
	private MeetingBoardService meetingBoardService;
	public void setMeetingBoardService(MeetingBoardService meetingBoardService) {
		this.meetingBoardService = meetingBoardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="/board/meeting/regist_success";
		
		try {
		MeetingBoardVO meetingboard 
		= (MeetingBoardVO)XSSHttpRequestParameterAdapter.execute(request, MeetingBoardVO.class);
		
		meetingboard.setM_content(request.getParameter("content"));
		
		meetingBoardService.regist(meetingboard);
		}catch(Exception e) {
			e.printStackTrace();
			//url=null;
			throw e;
		}		
		return url;
	}

}
