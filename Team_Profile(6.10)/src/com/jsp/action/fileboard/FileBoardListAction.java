package com.jsp.action.fileboard;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.SearchCriteriaCommand;
import com.jsp.controller.XSSHttpRequestParameterAdapter;
import com.jsp.service.FileBoardService;

public class FileBoardListAction implements Action {
	
	private FileBoardService fileBoardService;
	public void setFileBoardService(FileBoardService fileBoardService) {
		this.fileBoardService = fileBoardService;
	}


	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/file/list";
		try {
			SearchCriteriaCommand criCMD =  XSSHttpRequestParameterAdapter.execute(request, SearchCriteriaCommand.class);
	
			Criteria cri = criCMD.toSearchCriteria();
			
			
			Map<String, Object> dataMap = fileBoardService.getFileBoardList(cri);
			request.setAttribute("dataMap", dataMap);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
		
		return url;
	}

}
