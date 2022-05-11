package com.jsp.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.vo.BoardVO;

/**
 * Servlet implementation class MemberRegistServlet
 */
@WebServlet("/regist")
public class MemberRegistServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/regist.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		DataSource source1 = DataSource.getInstance();
		
		Date now = new Date();
		String format1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(now);


		
		
		//입력
		String bno = request.getParameter("bno");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String url = request.getContextPath()+"/dataSource";
		
		//keyset에서 최대값 구하기
		Integer maxKey = Collections.max(source1.getBoardList().keySet());

		
		//처리
		BoardVO board = new BoardVO(maxKey+1, title, content, writer, format1, 0);
		board.setBno(maxKey+1);
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		board.setRegDate(format1);
		board.setViewCnt(0);
		
		source1.getBoardList().put(maxKey+1, board);
		
	
		
		//System.out.println(member);
		
		//출력
		
		response.sendRedirect(url);
		/*
		 * request.setAttribute("member", member);
		 * request.getRequestDispatcher(url).forward(request,response);
		 */
	}

}








