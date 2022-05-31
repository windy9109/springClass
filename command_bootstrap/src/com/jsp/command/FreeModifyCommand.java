package com.jsp.command;

import com.jsp.dto.FreeVO;

public class FreeModifyCommand {
	

	private String bno;
	private String title;
	private String content;
	private String writer;
	

	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
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
	
	public FreeVO toFreeVO(){
		FreeVO free = new FreeVO();
		
		free.setBno(Integer.parseInt(this.bno));
		free.setTitle(this.title);
		free.setContent(this.content);
		free.setWriter(this.writer);	
		
		return free;
		
	}
	
}
