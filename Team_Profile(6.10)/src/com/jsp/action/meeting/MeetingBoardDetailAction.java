package com.jsp.action.meeting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MeetingBoardVO;
import com.jsp.service.MeetingBoardService;

public class MeetingBoardDetailAction implements Action {
	
	private MeetingBoardService meetingBoardService;
	public void setMeetingBoardService(MeetingBoardService meetingBoardService) {
		this.meetingBoardService = meetingBoardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/meeting/detail";

		try {
			int m_no = Integer.parseInt(request.getParameter("m_no"));
	
			
			MeetingBoardVO meetingBoard;
			meetingBoard=meetingBoardService.getMeetingBoardForModify(m_no);
			

			request.setAttribute("meetingBoard", meetingBoard);
		} catch (Exception e) {
			e.printStackTrace();
			url = null;
			throw e;
		}
		return url;
	}
}
