package com.jsp.command;

import com.jsp.dto.MeetingBoardVO;

public class MeetingBoardModifyCommand {
	private String m_no;
	private String m_title;
	private String m_content;
	private String m_writer;
	
	public String getM_no() {
		return m_no;
	}
	public String getM_title() {
		return m_title;
	}
	public String getM_content() {
		return m_content;
	}
	public String getM_writer() {
		return m_writer;
	}
	public void setM_no(String m_no) {
		this.m_no = m_no;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	public void setM_content(String m_content) {
		this.m_content = m_content;
	}
	public void setM_writer(String m_writer) {
		this.m_writer = m_writer;
	}
	 
	public MeetingBoardVO toMeetingBoardVO() {
		MeetingBoardVO meetingBoard = new MeetingBoardVO();
		
		meetingBoard.setM_no(Integer.parseInt(this.m_no));
		meetingBoard.setM_title(this.m_title);
		meetingBoard.setM_content(this.m_content);
		meetingBoard.setM_writer(m_writer);
		
		return meetingBoard;
	} 
	
}	
