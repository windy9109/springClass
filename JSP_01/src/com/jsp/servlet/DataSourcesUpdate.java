package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.vo.Member;

/**
 * Servlet implementation class MemberRegistServlet
 */
@WebServlet("/Supdate")
public class DataSourcesUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String url="/update.jsp";
		request.setAttribute("id", id);
		request.getRequestDispatcher(url).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataSource source1 = DataSource.getInstance();
		
		//입력
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String url = request.getContextPath()+"/dataSource";
		
		//처리
		Member member = new Member(id, pwd);
		member.setId(id);
		member.setPwd(pwd);
		
		source1.getMemberList().put(id, member);
		
		//memberService.regist(member); <-----DB저장
		
		System.out.println(member);
		
		//출력
		
		response.sendRedirect(url);
		/*
		 * request.setAttribute("member", member);
		 * request.getRequestDispatcher(url).forward(request,response);
		 */
	}

}








