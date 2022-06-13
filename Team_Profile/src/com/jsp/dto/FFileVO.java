package com.jsp.dto;

import java.util.Date;

public class FFileVO {
	
	private int a_no; 			 //고유번호
	private String uploadPath;	 //저장경로
	private String fileName;  	 //파일명
	private String fileType; 	 //파일형식
	private int f_no;          	 //자료공유 게시판 글번호
	/**
	 * @return the a_no
	 */
	public int getA_no() {
		return a_no;
	}
	/**
	 * @param a_no the a_no to set
	 */
	public void setA_no(int a_no) {
		this.a_no = a_no;
	}
	/**
	 * @return the uploadPath
	 */
	public String getUploadPath() {
		return uploadPath;
	}
	/**
	 * @param uploadPath the uploadPath to set
	 */
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}
	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
	 * @return the f_no
	 */
	public int getF_no() {
		return f_no;
	}
	/**
	 * @param f_no the f_no to set
	 */
	public void setF_no(int f_no) {
		this.f_no = f_no;
	}
	/**
	 * @return the attacher
	 */
	public String getAttacher() {
		return attacher;
	}
	/**
	 * @param attacher the attacher to set
	 */
	public void setAttacher(String attacher) {
		this.attacher = attacher;
	}
	/**
	 * @return the regDate
	 */
	public Date getRegDate() {
		return regDate;
	}
	/**
	 * @param regDate the regDate to set
	 */
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	private String attacher; 	 //등록자
	private Date regDate;    	 //등록일
	
}
