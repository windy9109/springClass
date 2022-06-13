package com.jsp.action.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.NoticeBoardVO;
import com.jsp.service.NoticeService;

public class NoticeDetailAction implements Action {
	
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/notice/detail";
		
		int i_no = Integer.parseInt(request.getParameter("i_no"));
		//System.out.println("nno"+nno);
		String from = request.getParameter("from");
		
		NoticeBoardVO notice = null;
		
		if (from != null && from.equals("list")) {
			notice = noticeService.getNotice(i_no);
			url="redirect:/board/notice/detail.do?i_no="+i_no;
			System.out.println(notice);
		}else {
			notice = noticeService.getNoticeForModify(i_no);
		}
		
		request.setAttribute("notice", notice);
		
		return url;
	}

}
