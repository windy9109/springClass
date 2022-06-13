package com.jsp.command;

public class SbReplyRemoveCommand {
	private String sb_rno;
	private String sb_no;
	private String sb_page;
	
	public int getSb_rno() {
		return Integer.parseInt(sb_rno);
	}
	public void setSb_rno(String sb_rno) {
		this.sb_rno = sb_rno;
	}
	public int getSb_no() {
		return Integer.parseInt(sb_no);
	}
	public void setSb_no(String sb_no) {
		this.sb_no = sb_no;
	}
	public int getSb_page() {
		return Integer.parseInt(sb_page);
	}
	public void setSb_page(String sb_page) {
		this.sb_page = sb_page;
	}
	
	
}
