package com.jsp.servlet;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.jsp.vo.Board;
import com.jsp.vo.Member;




public class DataSource {
	
	Date now = new Date();
	String format1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(now);
	
	private Map<Integer, Board> BoardList = new HashMap<Integer, Board>();
	
	private static DataSource instance = new DataSource();
	private DataSource() {
		for(int i=0;i<20;i++) {
			String temp = "mimi"+i;
			
			BoardList.put(i, new Board(i,temp,temp,temp, format1,0));
			
			//bno title writer content regDate viewCnt;
		} 
		
	}
	public static DataSource getInstance(){
		return instance;
	}
	public Map<Integer, Board> getBoardList() {
		return BoardList;
	}
	public void setBoardList(Map<Integer, Board> BoardList) {
		this.BoardList = BoardList;
	}
	public static void setInstance(DataSource instance) {
		DataSource.instance = instance;
	}
	
	
	
	
	
}
