package com.java.ot;

import java.util.Scanner;

public class Main {
	
	private Input inputis = new Input();
	private Output outputis = new Output();
	private Porccess porccessis = new Porccess();

	
	public static void main(String[] args) {
		
		Main main = new Main(); 
		
		String input = main.inputis.input();
		String porccess = main.porccessis.porccess(input);
		main.outputis.ouput(porccess);
		
		
	}

}
