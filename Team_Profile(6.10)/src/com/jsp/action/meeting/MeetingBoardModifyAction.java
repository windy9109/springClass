package com.jsp.action.meeting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.MeetingBoardModifyCommand;
import com.jsp.controller.XSSHttpRequestParameterAdapter;
import com.jsp.dto.MeetingBoardVO;
import com.jsp.service.MeetingBoardService;

public class MeetingBoardModifyAction implements Action {
	
	private MeetingBoardService meetingBoardService;
	public void setMeetingBoardService(MeetingBoardService meetingBoardService) {
		this.meetingBoardService = meetingBoardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "redirect:/board/meeting/detail.do?from=modify&m_no="+request.getParameter("m_no");
		
		try {
		MeetingBoardModifyCommand modifyReq 
		= (MeetingBoardModifyCommand)XSSHttpRequestParameterAdapter.execute(request, MeetingBoardModifyCommand.class, true);
		
		MeetingBoardVO meetingBoard = modifyReq.toMeetingBoardVO();
		meetingBoard.setM_content(request.getParameter("content"));
		
		meetingBoardService.modify(meetingBoard);
		}catch(Exception e) {
			e.printStackTrace();
			url = null;
			throw e;
		}			
		return url;
	}
}
