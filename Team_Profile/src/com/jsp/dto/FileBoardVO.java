package com.jsp.dto;

import java.util.Date;
import java.util.List;

public class FileBoardVO {
	private int f_no;
	private String f_title;
	private String f_content;
	private Date f_regDate;
	private String f_writer;

	public int getF_no() {
		return f_no;
	}

	public void setF_no(int f_no) {
		this.f_no = f_no;
	}

	public String getF_title() {
		return f_title;
	}

	public void setF_title(String f_title) {
		this.f_title = f_title;
	}

	public String getF_content() {
		return f_content;
	}

	public void setF_content(String f_content) {
		this.f_content = f_content;
	}

	public Date getF_regDate() {
		return f_regDate;
	}

	public void setF_regDate(Date f_regDate) {
		this.f_regDate = f_regDate;
	}

	public String getF_writer() {
		return f_writer;
	}

	public void setF_writer(String f_writer) {
		this.f_writer = f_writer;
	}
	
	private List<FFileVO> fFileList;
	public List<FFileVO> getfFileList() {
		return fFileList;
	}
	public void setfFileList(List<FFileVO> fFileList) {
		this.fFileList = fFileList;
	}
	
	

	

}
