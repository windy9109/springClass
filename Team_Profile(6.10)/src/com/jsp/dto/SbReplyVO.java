package com.jsp.dto;

import java.util.Date;

public class SbReplyVO {
	private int sb_rno;		// 댓글 번호
	private int sb_no;		// 게시글번호
	private String sb_rtext;
	private Date sb_rdate;
	private String sb_rmem;
	private Date sb_updatedate;
	
	private String picture;

	public int getSb_rno() {
		return sb_rno;
	}

	public void setSb_rno(int sb_rno) {
		this.sb_rno = sb_rno;
	}

	public int getSb_no() {
		return sb_no;
	}

	public void setSb_no(int sb_no) {
		this.sb_no = sb_no;
	}

	public String getSb_rtext() {
		return sb_rtext;
	}

	public void setSb_rtext(String sb_rtext) {
		this.sb_rtext = sb_rtext;
	}

	public Date getSb_rdate() {
		return sb_rdate;
	}

	public void setSb_rdate(Date sb_rdate) {
		this.sb_rdate = sb_rdate;
	}

	public String getSb_rmem() {
		return sb_rmem;
	}

	public void setSb_rmem(String sb_rmem) {
		this.sb_rmem = sb_rmem;
	}

	public Date getSb_updatedate() {
		return sb_updatedate;
	}

	public void setSb_updatedate(Date sb_updatedate) {
		this.sb_updatedate = sb_updatedate;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	
}
