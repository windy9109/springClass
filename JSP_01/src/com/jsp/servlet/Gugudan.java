package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Gugudan
 */
@WebServlet("/gugudan")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String gugu = request.getParameter("gugu");
		
		//입력
		int dan = 5;
		String result="";
		

			result += "<h3>"+dan+"입니다</h3>";
			for(int j=1; j<10; j++){
				result += dan+"*"+j+"="+dan*j+"</br>";
			}
			result += "<br/>";
		//출력
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println(result);
			
		request.setAttribute("result", result);
		request.getRequestDispatcher("/gugudan.jsp").forward(request, response);
	}

}
