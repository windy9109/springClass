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

import com.jsp.vo.Board;
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
		
		Map<Integer, Board> data = source.getBoardList();
		List<Board> BoardList = new ArrayList<Board>(data.values());
		
		request.setAttribute("data", BoardList);
		request.getRequestDispatcher(url).forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}


}
