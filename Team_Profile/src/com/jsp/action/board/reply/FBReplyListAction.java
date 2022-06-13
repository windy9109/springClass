package com.jsp.action.board.reply;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.SearchCriteria;
import com.jsp.command.SearchCriteriaCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.controller.JSONResolver;
import com.jsp.service.FBReplyService;

public class FBReplyListAction implements Action {
	
	private FBReplyService fBReplyService;
	public void setfBReplyService(FBReplyService fBReplyService) {
		this.fBReplyService = fBReplyService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		int fb_no = Integer.parseInt(request.getParameter("fb_no"));
		
		SearchCriteriaCommand criCMD = HttpRequestParameterAdapter.execute(request, SearchCriteriaCommand.class);
		
		SearchCriteria cri = criCMD.toSearchCriteria();
		
		Map<String, Object> dataMap = fBReplyService.getFBReplyList(fb_no, cri);
		
		JSONResolver.view(response, dataMap);
		
		return url;
	}

}
