package com.jsp.action.fileboard;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.FFileVO;
import com.jsp.service.FileBoardService;

public class FileBoardRemoveAction implements Action {
	
	private FileBoardService fileBoardService;
	public void setFileBoardService(FileBoardService fileBoardService) {
		this.fileBoardService = fileBoardService;
	} 

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/file/remove_success";
		
		int f_no = Integer.parseInt(request.getParameter("f_no"));
		
		try {
			List<FFileVO> fFileList = fileBoardService.getFileBoard(f_no).getfFileList();
			
			if(fFileList != null) {
				for(FFileVO fFile : fFileList) {
					String storedFilePath = fFile.getUploadPath() + File.separator + fFile.getFileName();
					
					File file = new File(storedFilePath);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return url;
	}

}
