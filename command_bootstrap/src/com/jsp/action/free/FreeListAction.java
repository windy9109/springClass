package com.jsp.action.free;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.SearchCriteria;
import com.jsp.command.SearchCriteriaCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.service.FreeService;
import com.jsp.service.NoticeService;

public class FreeListAction implements Action {

	
	private FreeService freeService;
	
	public void setFreeService(FreeService freeService) {
		this.freeService = freeService;
	}



	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/list";
		
		SearchCriteria cri = null;
		//입력
		try {
			SearchCriteriaCommand command 
				= HttpRequestParameterAdapter.execute(request, SearchCriteriaCommand.class);
			cri = command.toSearchCriteria();				
		
			//처리
			Map<String, Object> dataMap = freeService.getFreeList(cri);
			System.out.println(dataMap);
			request.setAttribute("dataMap", dataMap);
			
			return url;
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
