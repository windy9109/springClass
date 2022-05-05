package com.jsp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.vo.Member;

/**
 * Servlet implementation class DataSource
 */
@WebServlet("/Sdetail")
public class DataSourcesDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		DataSource source1 = DataSource.getInstance();

		//입력
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String url = "/detail.jsp";
		
		
		//memberService.regist(member); <-----DB저장
		
		
		//출력
		//response.sendRedirect(url);
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
		request.getRequestDispatcher(url).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}


}
