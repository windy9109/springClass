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

import com.jsp.command.Criteria;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;
import com.jsp.vo.BoardVO;

/**
 * Servlet implementation class DataSource
 */
@WebServlet("/dataSource")
public class DataSource2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberService memberService = new MemberServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String url ="/dataSource.jsp";
		String pageParam = request.getParameter("page");
		String perPageNumParam = request.getParameter("perPageNum");
		
		Criteria cri = new Criteria();
		boolean criFlag = true;
		criFlag = criFlag && pageParam != null
				&& !pageParam.isEmpty()
				&& perPageNumParam != null
				&& !perPageNumParam.isEmpty();
		if(criFlag) {
			try {
				cri.setPage(Integer.parseInt(pageParam));
				cri.setPerPageNum(Integer.parseInt(perPageNumParam));
			} catch (Exception e) {
				response.sendError(response.SC_BAD_REQUEST);
				return; //값이 없는 메소드는 돌아가라
			}
		}
		
		try {
			List<BoardVO> memberList = memberService.getMemberList(cri);
			request.setAttribute("memberList", memberList);
		} catch (Exception e) {
			//에러
			url="/WEB-INF/views/error/500.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}


}
