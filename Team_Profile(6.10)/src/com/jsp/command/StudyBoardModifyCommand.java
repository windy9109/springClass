package com.jsp.command;

import java.util.Date;

import com.jsp.dto.StudyBoardVO;

public class StudyBoardModifyCommand {

	private String s_no;
	private String s_title;
	private String s_writer;
	private String s_content;

	public String getS_no() {
		return s_no;
	}

	public void setS_no(String s_no) {
		this.s_no = s_no;
	}

	public String getS_title() {
		return s_title;
	}

	public void setS_title(String s_title) {
		this.s_title = s_title;
	}

	public String getS_writer() {
		return s_writer;
	}

	public void setS_writer(String s_writer) {
		this.s_writer = s_writer;
	}

	public String getS_content() {
		return s_content;
	}

	public void setS_content(String s_content) {
		this.s_content = s_content;
	}

	public StudyBoardVO toStudyBoardVO() {
		StudyBoardVO studyboard = new StudyBoardVO();
		studyboard.setS_no(Integer.parseInt(this.s_no));
		studyboard.setS_writer(this.s_writer);
		studyboard.setS_content(this.s_content);
		studyboard.setS_updatedate(new Date());
		studyboard.setS_title(this.s_title);

		return studyboard;
	}
}
