package com.jsp.action.free;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.XSSHttpRequestParameterAdapter;
import com.jsp.dto.FreeVO;
import com.jsp.dto.NoticeVO;
import com.jsp.service.FreeService;
import com.jsp.service.NoticeService;

public class FreeRegistAction implements Action {
	

	private FreeService freeService;
	public void setFreeService(FreeService freeService) {
		this.freeService = freeService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="/board/regist_success";
		
		FreeVO free = XSSHttpRequestParameterAdapter.execute(request, FreeVO.class,true);
		
		//smartEditor parameter 제외
		free.setContent(request.getParameter("content"));
		
		freeService.regist(free);
		
		return url;
	}

}
