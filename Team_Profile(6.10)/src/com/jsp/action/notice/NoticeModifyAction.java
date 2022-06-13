package com.jsp.action.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.NoticeModifyCommand;
import com.jsp.controller.XSSHttpRequestParameterAdapter;
import com.jsp.dto.NoticeBoardVO;
import com.jsp.service.NoticeService;

public class NoticeModifyAction implements Action {

	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "redirect:/notice/detail.do?nno=" + request.getParameter("i_no");
		
		NoticeModifyCommand noticeReq = XSSHttpRequestParameterAdapter.execute(request, NoticeModifyCommand.class, true);
		NoticeBoardVO notice = noticeReq.toNoticeVO();
		
		notice.setI_content((String)request.getParameter("content"));
		
		noticeService.modify(notice);
		
		return url;
	}

}
