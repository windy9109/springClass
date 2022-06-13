package com.jsp.dto;

import java.util.Date;

public class StudyBoardVO {
	private int s_no;		// 글번호
	private String s_title="";
	private String s_content="";
	private String s_writer="";
	private int s_viewcnt=0;
	private Date s_regdate=new Date();
	private Date s_updatedate=new Date();
	
	private int sbreplycnt;		// 댓글 개수

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getS_title() {
		return s_title;
	}

	public void setS_title(String s_title) {
		this.s_title = s_title;
	}

	public String getS_content() {
		return s_content;
	}

	public void setS_content(String s_content) {
		this.s_content = s_content;
	}

	public String getS_writer() {
		return s_writer;
	}

	public void setS_writer(String s_writer) {
		this.s_writer = s_writer;
	}

	public int getS_viewcnt() {
		return s_viewcnt;
	}

	public void setS_viewcnt(int s_viewcnt) {
		this.s_viewcnt = s_viewcnt;
	}

	public Date getS_regdate() {
		return s_regdate;
	}

	public void setS_regdate(Date s_regdate) {
		this.s_regdate = s_regdate;
	}

	public Date getS_updatedate() {
		return s_updatedate;
	}

	public void setS_updatedate(Date s_updatedate) {
		this.s_updatedate = s_updatedate;
	}

	public int getSbreplycnt() {
		return sbreplycnt;
	}

	public void setSbreplycnt(int sbreplycnt) {
		this.sbreplycnt = sbreplycnt;
	}
	
	
	
}
