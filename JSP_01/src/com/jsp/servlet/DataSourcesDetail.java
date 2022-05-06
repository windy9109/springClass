package com.jsp.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.vo.Board;
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
		String bno = request.getParameter("bno");
		String url = "/detail.jsp";
		
		// 현재 날짜 구하기
		LocalDate now = LocalDate.now();
		// 포맷 정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		// 포맷 적용
		//String formatedNow = now.format(formatter);

		
		//memberService.regist(member); <-----DB저장
		
		//source1.getBoardList().get(Integer.parseInt(bno));
		
		//source1.getBoardList().get(Integer.parseInt(bno));
		
		
		
		//source1.getBoardList().get(Integer.parseInt(bno)).getBno();
		String Content = source1.getBoardList().get(Integer.parseInt(bno)).getContent();
		String Title = source1.getBoardList().get(Integer.parseInt(bno)).getTitle();
		String Writer = source1.getBoardList().get(Integer.parseInt(bno)).getWriter();
		int ViewCnt = source1.getBoardList().get(Integer.parseInt(bno)).getViewCnt();
		String RegDate = source1.getBoardList().get(Integer.parseInt(bno)).getRegDate();
		
		
		Board board = new Board(Integer.parseInt(bno), Title, Content, Writer, RegDate, ViewCnt);
		board.setViewCnt(ViewCnt+1);
		
		source1.getBoardList().put(Integer.parseInt(bno), board);
		
		
		//출력
		//response.sendRedirect(url);
		request.setAttribute("bno", bno);
		request.setAttribute("title", Title);
		request.setAttribute("writer", Writer);
		request.setAttribute("content", Content);
		request.setAttribute("regDate", now.format(formatter));
		request.setAttribute("viewCnt", ViewCnt);
		request.getRequestDispatcher(url).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}


}
