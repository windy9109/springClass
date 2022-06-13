package com.jsp.action.fileboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.MakeFileName;
import com.jsp.dto.FFileVO;
import com.jsp.dto.FileBoardVO;
import com.jsp.service.FileBoardService;

public class FileBoardDetailAction implements Action {
	
	private FileBoardService fileBoardService;
	public void setFileBoardService(FileBoardService fileBoardService) {
		this.fileBoardService = fileBoardService;
	} 

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/file/detail";
		
		int f_no = Integer.parseInt(request.getParameter("f_no"));
		String from = request.getParameter("from");
		
		try {
			FileBoardVO fileBoard =null; 
			fileBoard = fileBoardService.getFileBoard(f_no);
			
			
			List<FFileVO> renamedAttachList=MakeFileName.parseFileNameFromFFiles(fileBoard.getfFileList(), "\\$\\$");
			fileBoard.setfFileList(renamedAttachList);
			
			request.setAttribute("fileBoard", fileBoard);
			
		} catch (Exception e) {			
			e.printStackTrace();
			url=null;
			throw e;
		}		
		
		return url;
		
	}

}
