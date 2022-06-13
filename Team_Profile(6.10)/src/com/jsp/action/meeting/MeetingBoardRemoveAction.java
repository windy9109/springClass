package com.jsp.action.meeting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.MeetingBoardService;

public class MeetingBoardRemoveAction implements Action {

	private MeetingBoardService meetingBoardService;
	public void setMeetingBoardService(MeetingBoardService meetingBoardService) {
		this.meetingBoardService = meetingBoardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/meeting/remove_success";
		try {
			int m_no = Integer.parseInt(request.getParameter("m_no"));
		
			meetingBoardService.remove(m_no);
		}catch(Exception e) {			
			url= null;
			e.printStackTrace();
			throw e;
		}
		return url;
	}

}
