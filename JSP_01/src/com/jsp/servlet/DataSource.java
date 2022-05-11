package com.jsp.servlet;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.jsp.vo.BoardVO;




public class DataSource {
	
	Date now = new Date();
	String format1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(now);
	
	private Map<Integer, BoardVO> BoardList = new HashMap<Integer, BoardVO>();
	
	private static DataSource instance = new DataSource();
	private DataSource() {
		for(int i=0;i<20;i++) {
			String temp = "mimi"+i;
			
			BoardList.put(i, new BoardVO(i,temp,temp,temp, format1,0));
			
			//bno title writer content regDate viewCnt;
		} 
		
	}
	public static DataSource getInstance(){
		return instance;
	}
	public Map<Integer, BoardVO> getBoardList() {
		return BoardList;
	}
	public void setBoardList(Map<Integer, BoardVO> BoardList) {
		this.BoardList = BoardList;
	}
	public static void setInstance(DataSource instance) {
		DataSource.instance = instance;
	}
	
	
	
	
	
}
