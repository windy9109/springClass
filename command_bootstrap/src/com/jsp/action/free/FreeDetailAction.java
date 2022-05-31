package com.jsp.action.free;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.FreeVO;
import com.jsp.dto.NoticeVO;
import com.jsp.service.FreeService;
import com.jsp.service.NoticeService;

public class FreeDetailAction implements Action {
	

	private FreeService freeService;
	
	public void setFreeService(FreeService freeService) {
		this.freeService = freeService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/detail";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String from = request.getParameter("from");
		
		FreeVO free = null;
		
		if (from != null && from.equals("list")) {
			free = freeService.getFree(bno);
			url="redirect:/board/detail.do?bno="+bno;
		}else {
			free = freeService.getFreeForModify(bno);
		}
		
		request.setAttribute("free", free);
		
		return url;
	}

}
