package com.jsp.action.free;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.FreeService;
import com.jsp.service.NoticeService;

public class FreeRemoveAction implements Action {
	

	private FreeService freeService;
	public void setFreeService(FreeService freeService) {
		this.freeService = freeService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/remove_success";
		
		int nno = Integer.parseInt(request.getParameter("bno"));

		freeService.remove(nno);
		
		return url;
	}

}
