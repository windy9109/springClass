package com.jsp.action.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.XSSHttpRequestParameterAdapter;
import com.jsp.dto.NoticeBoardVO;
import com.jsp.service.NoticeService;

public class NoticeRegistAction implements Action {

	private NoticeService noticeService;

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/notice/regist_success";

		NoticeBoardVO notice = XSSHttpRequestParameterAdapter.execute(request, NoticeBoardVO.class, true);
		System.out.println("request.getParameter: "+request.getParameter("content"));
		// smartEditor parameter 제외
		notice.setI_title(request.getParameter("title"));
		notice.setI_writer(request.getParameter("writer"));
		notice.setI_content(request.getParameter("content"));

		
		System.out.println(notice);
		
		noticeService.regist(notice);

		return url;
	}

}
