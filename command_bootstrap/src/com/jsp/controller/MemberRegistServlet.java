package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.command.MemberRegistCommand;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.SearchMemberServiceImpl;


@WebServlet("/member/regist")
public class MemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new SearchMemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String url = "/WEB-INF/views/member/regist.jsp";
		String url = "/member/regist";
		//request.getRequestDispatcher(url).forward(request, response);
		request.setAttribute("viewName", url);
		InternalViewResolver.view(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//화면
		String url = "/member/regist_success";
	
		//입력
		try {
			request.setCharacterEncoding("utf-8");
			MemberRegistCommand command = (MemberRegistCommand)HttpRequestParamterAdaper.execute(request, MemberRegistCommand.class);
			MemberVO member = command.toMemberVO();
			//처리
			memberService.regist(member);
			
			//출력
			//취지와 맞지않음
//			response.setContentType("text/html; charset=utf=8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("alert('등록완료!')");
//			out.println("window.close();");
//			out.println("window.opener.location.reload();");
//			out.println("</script>");
			
			//response.sendRedirect(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Exception 처리...
			url="/member/regist_fail";
		}
		
		request.setAttribute("viewName", url);
		InternalViewResolver.view(request, response);
		
		
	}

}
