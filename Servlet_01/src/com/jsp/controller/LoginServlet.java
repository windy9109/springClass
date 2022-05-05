package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/common/login.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 입력(id/pass)
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String message="";
		
		//로그인 처리
		if( id != null && id.equals("mimi")) {
			if(pass != null && pass.equals("mimi")) {
				message +="로그인 성공";
			}else {
				message +="로그인 실패, 패스워드 불일치";
			}
		}else {
			message +="로그인 실패, 아이디 불일치";
		}
		
		
		//출력
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('"+message+"')");
		out.print("</script>");
		
		//localhost/Servlet_01/login?id=mimi&pass=mimi
	
	}

}
