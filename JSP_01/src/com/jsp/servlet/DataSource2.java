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
@WebServlet("/dataSource")
public class DataSource2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/dataSource.jsp";
	

		DataSource source = DataSource.getInstance();
		
		Map<String, Member> data = source.getMemberList();
		List<Member> memberList = new ArrayList<Member>(data.values());
		
		request.setAttribute("data", memberList);
		request.getRequestDispatcher(url).forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}


}
