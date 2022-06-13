package com.jsp.dto;

import java.util.Date;

public class NoticeBoardVO {
	private int i_no;			// 글번호
	private String i_title="";		// 글제목
	private String i_content="";	// 글내용
	private Date  i_regdate=new Date();	// 글작성날짜
	private String i_writer="";	// 작성자
	private int i_viewcnt=0;	// 조회수
	
	
	public int getI_no() {
		return i_no;
	}
	public void setI_no(int i_no) {
		this.i_no = i_no;
	}
	public int getI_viewcnt() {
		return i_viewcnt;
	}
	public void setI_viewcnt(int i_viewcnt) {
		this.i_viewcnt = i_viewcnt;
	}
	public String getI_title() {
		return i_title;
	}
	public void setI_title(String i_title) {
		this.i_title = i_title;
	}
	public String getI_content() {
		return i_content;
	}
	public void setI_content(String i_content) {
		this.i_content = i_content;
	}
	public Date getI_regdate() {
		return i_regdate;
	}
	public void setI_regdate(Date i_regdate) {
		this.i_regdate = i_regdate;
	}
	public String getI_writer() {
		return i_writer;
	}
	public void setI_writer(String i_writer) {
		this.i_writer = i_writer;
	}
	@Override
	public String toString() {
		return "NoticeBoardVO [i_no=" + i_no + ", i_title=" + i_title + ", i_content=" + i_content + ", i_regdate="
				+ i_regdate + ", i_writer=" + i_writer + ", i_viewcnt=" + i_viewcnt + "]";
	}
	
	
	
	
	
}
