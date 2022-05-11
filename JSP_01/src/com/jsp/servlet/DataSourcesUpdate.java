package com.jsp.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.vo.BoardVO;

/**
 * Servlet implementation class MemberRegistServlet
 */
@WebServlet("/Supdate")
public class DataSourcesUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bno = request.getParameter("bno");
		String url="/update.jsp";
		request.setAttribute("bno", bno);
		request.getRequestDispatcher(url).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html; charset=UTF-8");
		DataSource source1 = DataSource.getInstance();
		
		//입력
		String bno = request.getParameter("bno");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		String url = request.getContextPath()+"/dataSource";
		
		System.out.println(bno);
		System.out.println(title);
		System.out.println(content);
		
	
		String Writer = source1.getBoardList().get(Integer.parseInt(bno)).getWriter();
		int ViewCnt = source1.getBoardList().get(Integer.parseInt(bno)).getViewCnt();
		String RegDate = source1.getBoardList().get(Integer.parseInt(bno)).getRegDate();

		
		
		//처리
		BoardVO board = new BoardVO(Integer.parseInt(bno), title, content, Writer, RegDate, ViewCnt);
		board.setBno(Integer.parseInt(bno));
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(Writer);
		board.setRegDate(RegDate);
		board.setViewCnt(ViewCnt);
		
		source1.getBoardList().put(Integer.parseInt(bno), board);
		
		//memberService.regist(member); <-----DB저장
		
		//System.out.println(board);
		
		//출력
		
		response.sendRedirect(url);
		/*
		 * request.setAttribute("member", member);
		 * request.getRequestDispatcher(url).forward(request,response);
		 */
	}

}








