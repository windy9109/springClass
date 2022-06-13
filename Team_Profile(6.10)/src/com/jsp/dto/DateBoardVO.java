package com.jsp.dto;

import java.util.Date;

public class DateBoardVO {
	private int d_no;
	private String d_title;
	private String d_content;
	private Date d_regdate;
	private int d_percent;
	private String d_writer;
	
	public void setD_no(int d_no) {
		this.d_no = d_no;
	}
	public void setD_title(String d_title) {
		this.d_title = d_title;
	}
	public void setD_content(String d_content) {
		this.d_content = d_content;
	}
	public void setD_regdate(Date d_regdate) {
		this.d_regdate = d_regdate;
	}
	public void setD_percent(int d_percent) {
		this.d_percent = d_percent;
	}
	public void setD_writer(String d_writer) {
		this.d_writer = d_writer;
	}
	public int getD_no() {
		return d_no;
	}
	public String getD_title() {
		return d_title;
	}
	public String getD_content() {
		return d_content;
	}
	public Date getD_regdate() {
		return d_regdate;
	}
	public int getD_percent() {
		return d_percent;
	}
	public String getD_writer() {
		return d_writer;
	}
	
	
}
