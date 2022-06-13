package com.jsp.command;

import com.jsp.dto.NoticeBoardVO;

public class NoticeModifyCommand {
	private String i_no;
	private String i_title;
	private String i_content;
	private String i_writer;

	public String getI_no() {
		return i_no;
	}

	public void setI_no(String i_no) {
		this.i_no = i_no;
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

	public String getI_writer() {
		return i_writer;
	}

	public void setI_writer(String i_writer) {
		this.i_writer = i_writer;
	}

	public NoticeBoardVO toNoticeVO() {
		NoticeBoardVO notice = new NoticeBoardVO();

		notice.setI_no(Integer.parseInt(this.i_no));
		notice.setI_title(this.i_title);
		notice.setI_content(this.i_content);
		notice.setI_writer(i_writer);

		return notice;
	}
}
