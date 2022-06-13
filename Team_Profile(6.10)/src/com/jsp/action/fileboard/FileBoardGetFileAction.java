package com.jsp.action.fileboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.FileDownloadResolver;
import com.jsp.dto.FFileVO;
import com.jsp.service.FileBoardService;

public class FileBoardGetFileAction implements Action {

	private FileBoardService fileBoardService;
	public void setFileBoardService(FileBoardService fileBoardService) {
		this.fileBoardService = fileBoardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		try {
			int a_no = Integer.parseInt(request.getParameter("a_no"));
			System.out.println(a_no);
			
			FFileVO fFile = fileBoardService.getFFileBya_no(a_no);
			if(fFile == null) System.out.println("fFile null");
			
			String fileName = fFile.getFileName();
			String savedPath = fFile.getUploadPath();
			
			FileDownloadResolver.sendFile(fileName, savedPath, request, response);
		} catch (Exception e) {
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
			url=null;
			e.printStackTrace();
		}
		
		return url;
	}

}
