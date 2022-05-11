package com.jsp.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;
import com.jsp.vo.BoardVO;

/**
 * Servlet implementation class DataSource
 */
@WebServlet("/Sdetail")
public class DataSourcesDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private MemberService memberService = new MemberServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//DataSource source1 = DataSource.getInstance();

		//입력
		String bno = request.getParameter("bno");
		String url = "/detail.jsp";
		
		// 현재 날짜 구하기
		//LocalDate now = LocalDate.now();
		// 포맷 정의
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		// 포맷 적용
		//String formatedNow = now.format(formatter);

		
		//memberService.regist(member); <-----DB저장
		
		//source1.getBoardList().get(Integer.parseInt(bno));
		//source1.getBoardList().get(Integer.parseInt(bno));
		
		
		//data.values()
//		List<BoardVO> BoardList;
//		try {
//			BoardList = memberService.getMemberList();
//			Map<Integer, BoardVO> data = new HashMap<Integer, BoardVO>();
//			for(BoardVO boardList : BoardList) {
//				data.put(BoardList.bno, )
//			}
//			
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		String Title = null;
		String  Writer= null;
		String Content= null;
		String RegDate= null;
		int ViewCnt=0;
		
		//source1.getBoardList().get(Integer.parseInt(bno)).getBno();
		//String Content = memberService.getMemberList().get(Integer.parseInt(bno)).getContent();
		try {
			
			// 존재 여부 확인
			List<BoardVO> BoardList = memberService.getMemberList();
			for(BoardVO boardList : BoardList) {
				if(boardList.getBno() == Integer.parseInt(bno)) {
					
					Title = boardList.getTitle();
					Writer = boardList.getWriter();
					Content = boardList.getContent();
					RegDate = boardList.getRegDate();
					ViewCnt = boardList.getViewCnt();

				}
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String Title = source1.getBoardList().get(Integer.parseInt(bno)).getTitle();
//		String Writer = source1.getBoardList().get(Integer.parseInt(bno)).getWriter();
//		int ViewCnt = source1.getBoardList().get(Integer.parseInt(bno)).getViewCnt();
//		String RegDate = source1.getBoardList().get(Integer.parseInt(bno)).getRegDate();
//		
//		
		BoardVO board = new BoardVO(Integer.parseInt(bno), Title, Content, Writer, RegDate, ViewCnt);
//		board.setViewCnt(ViewCnt+1);
//		
//		source1.getBoardList().put(Integer.parseInt(bno), board);
		
		
		
		
		//출력

		request.setAttribute("bno", bno);
		request.setAttribute("title", Title);
		request.setAttribute("writer", Writer);
		request.setAttribute("content", Content);
		request.setAttribute("regDate", RegDate);
		request.setAttribute("viewCnt", ViewCnt);
		request.getRequestDispatcher(url).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}


}
