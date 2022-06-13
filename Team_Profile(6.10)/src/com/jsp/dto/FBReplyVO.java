package com.jsp.dto;

import java.util.Date;

public class FBReplyVO {
	private int fb_rno;
	private String fb_rtext;
	private Date fb_rdate;
	private int fb_no;
	private String fb_replyer;
	
//	private String picture;		 //작성자 사진
//	public String getPicture() {
//		return picture;
//	}
//	public void setPicture(String picture) {
//		this.picture = picture;
//	}
	
	
	public int getFb_rno() {
		return fb_rno;
	}
	public void setFb_rno(int fb_rno) {
		this.fb_rno = fb_rno;
	}
	public String getFb_rtext() {
		return fb_rtext;
	}
	public void setFb_rtext(String fb_rtext) {
		this.fb_rtext = fb_rtext;
	}
	public Date getFb_rdate() {
		return fb_rdate;
	}
	public void setFb_rdate(Date fb_rdate) {
		this.fb_rdate = fb_rdate;
	}
	public int getFb_no() {
		return fb_no;
	}
	public void setFb_no(int fb_no) {
		this.fb_no = fb_no;
	}
	public String getFb_replyer() {
		return fb_replyer;
	}
	public void setFb_replyer(String fb_replyer) {
		this.fb_replyer = fb_replyer;
	}
	
	
	

}
