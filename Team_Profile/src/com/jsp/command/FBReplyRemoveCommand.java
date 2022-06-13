package com.jsp.command;

public class FBReplyRemoveCommand {
	private String fb_rno;
	private String page;
	private String fb_no;
	
	public int getFb_rno() {
		return Integer.parseInt(fb_rno);
	}
	public void setFb_rno(String fb_rno) {
		this.fb_rno = fb_rno;
	}
	public int getPage() {
		return Integer.parseInt(page);
	}
	public void setPage(String page) {
		this.page = page;
	}
	public int getFb_no() {
		return Integer.parseInt(fb_no);
	}
	public void setFb_no(String fb_no) {
		this.fb_no = fb_no;
	}
}
