package com.java.ot;

public class Porccess {

	
	public String porccess(String input){
		String str = "";
		
		//ó��
		if(input == null) return null;
	
		try {
			Integer.parseInt(input);
			//����
			str += "����:";
		} catch (Exception e) {
			str += "����:";
		}
		str += input;
		return str;
		
	}
	
	
}
