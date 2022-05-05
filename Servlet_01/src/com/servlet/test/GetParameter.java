package com.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/param")
public class GetParameter extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String color = request.getParameter("color");
		String result = request.getParameter("result");
		//System.out.println(color);
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("text/html; charset=UTF-8");
		out.print("<style>");
		out.print("body{background:");
		out.print(color);
		out.print("}");
		out.print("</style>");
		  
		
		out.print("<h1>"+color+"</h1>");
		
		
		
//		request.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		response.setCharacterEncoding("text/html; charset=UTF-8");
//		response.getWriter().println("�븞�뀞�븯�꽭�슂");
		
	}

}
