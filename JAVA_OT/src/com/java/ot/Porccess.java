package com.java.ot;

public class Porccess {

	
	public String porccess(String input){
		String str = "";
		
		//처리
		if(input == null) return null;
	
		try {
			Integer.parseInt(input);
			//숫자
			str += "숫자:";
		} catch (Exception e) {
			str += "문자:";
		}
		str += input;
		return str;
		
	}
	
	
}
