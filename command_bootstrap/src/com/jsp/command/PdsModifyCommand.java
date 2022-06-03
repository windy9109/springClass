package com.jsp.command;

import com.jsp.dto.PdsVO;

public class PdsModifyCommand {
	

	private String pno;
	private String title;
	private String content;
	private String writer;
	

	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public PdsVO toPdsVO(){
		PdsVO free = new PdsVO();
		
		free.setPno(Integer.parseInt(this.pno));
		free.setTitle(this.title);
		free.setContent(this.content);
		free.setWriter(this.writer);	
		
		return free;
		
	}
	
}
