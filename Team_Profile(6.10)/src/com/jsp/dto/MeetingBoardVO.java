package com.jsp.dto;

import java.util.Date;

public class MeetingBoardVO {
	private int m_no;
	private String m_title;
	private String m_content;
	private Date m_regdate;
	private String m_writer;
	
	public int getM_no() {
		return m_no;
	}
	public String getM_title() {
		return m_title;
	}
	public String getM_content() {
		return m_content;
	}
	public Date getM_regdate() {
		return m_regdate;
	}
	public String getM_writer() {
		return m_writer;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	public void setM_content(String m_content) {
		this.m_content = m_content;
	}
	public void setM_regdate(Date m_regdate) {
		this.m_regdate = m_regdate;
	}
	public void setM_writer(String m_writer) {
		this.m_writer = m_writer;
	}
	
	
}
