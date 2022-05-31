package com.jsp.action.free;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.FreeModifyCommand;
import com.jsp.command.NoticeModifyCommand;
import com.jsp.controller.XSSHttpRequestParameterAdapter;
import com.jsp.dto.FreeVO;
import com.jsp.dto.NoticeVO;
import com.jsp.service.FreeService;
import com.jsp.service.NoticeService;

public class FreeModifyAction implements Action {
	

	private FreeService freeService;
	
	public void setFreeService(FreeService freeService) {
		this.freeService = freeService;
	}
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "redirect:/board/detail.do?bno="+request.getParameter("bno");
		
		FreeModifyCommand freeReq =XSSHttpRequestParameterAdapter.execute(request, FreeModifyCommand.class,true);		
		FreeVO free = freeReq.toFreeVO();
		
		free.setContent((String)request.getParameter("content"));				
		
		freeService.modify(free);
		
		return url;
	}

}
