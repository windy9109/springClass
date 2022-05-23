package com.jsp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.SearchMemberServiceImpl;

/**
 * Servlet implementation class MemberDetailServlet
 */
@WebServlet("/member/detail")
public class MemberDetailServlet extends HttpServlet {

	private MemberService memberService = new SearchMemberServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/member/detail";
		String id = request.getParameter("id");
		
		MemberVO member;
		try {
			member = memberService.getMember(id);
			request.setAttribute("member", member);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			url = "/member/detail_fail";
		}
		
		request.setAttribute("viewName", url);
		InternalViewResolver.view(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
