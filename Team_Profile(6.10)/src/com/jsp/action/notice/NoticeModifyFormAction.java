package com.jsp.action.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.NoticeBoardVO;
import com.jsp.service.NoticeService;

public class NoticeModifyFormAction implements Action {

	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/notice/regist";
		
		int i_no = Integer.parseInt(request.getParameter("i_no"));
		
		NoticeBoardVO notice = noticeService.getNoticeForModify(i_no);
		request.setAttribute("/board/notice", notice);
		
		return url;
	}

}
