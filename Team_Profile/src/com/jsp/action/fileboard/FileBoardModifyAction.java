package com.jsp.action.fileboard;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.ibatis.annotations.Insert;

import com.jsp.action.Action;
import com.jsp.controller.FileUploadResolver;
import com.jsp.controller.GetUploadPath;
import com.jsp.controller.XSSMultipartHttpServletRequestParser;
import com.jsp.dto.FFileVO;
import com.jsp.dto.FileBoardVO;
import com.jsp.service.FileBoardService;

public class FileBoardModifyAction implements Action {
	
	private FileBoardService fileBoardService;
	public void setFileBoardService(FileBoardService fileBoardService) {
		this.fileBoardService = fileBoardService;
	} 

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/file/modify_success";
		
		try {
			FileBoardVO fileBoard = modifyFFiles(request,response);
			
			fileBoardService.modify(fileBoard);
			
			request.setAttribute("fileBoard", fileBoard);
			
		} catch (Exception e) {
			e.printStackTrace();
			url = null;
			throw e;
		}
		
		return url;
	}
	
	final private int MEMORY_THRESHOLD = 1024*1024*3; // 3MB
	final private int MAX_FILE_SIZE = 1024*1024*40; // 40MB
	final private int MAX_REQUEST_SIZE = 1024*1024*200; // 200MB
	
	private FileBoardVO modifyFFiles(HttpServletRequest request, HttpServletResponse response) throws Exception{
		FileBoardVO fileBoard = null;
		
		XSSMultipartHttpServletRequestParser multi = new XSSMultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
		
		// 파일 삭제 및 DB삭제
		String[] deleteFiles = multi.getParameterValues("deleteFile");
		if (deleteFiles != null && deleteFiles.length > 0) {
			for(String anoStr : deleteFiles) {
				int a_no = Integer.parseInt(anoStr);
				FFileVO fFile = fileBoardService.getFFileBya_no(a_no);
				String filePath = fFile.getUploadPath() + File.separator + fFile.getFileName();
				File targetFile = new File(filePath);
				
				if (targetFile.exists()) {
					targetFile.delete();
				}
				
				fileBoardService.removeFFileBya_no(a_no);
			}
		}
		
		// 추가된 파일 저장
		FileItem[] fileItems = multi.getFileItems("uploadFile");
		List<FFileVO> fFileList = null;
		if (fileItems != null && fileItems.length > 0) {
			String uploadPath = GetUploadPath.getUploadPath("fileBoard.upload");
			List<File> fileList = FileUploadResolver.fileUpload(fileItems, uploadPath);
			
			fFileList = new ArrayList<FFileVO>();
			if(fileList.size()>0) for(File file : fileList) {
				FFileVO fFile = new FFileVO();
				fFile.setFileName(file.getName());
				fFile.setUploadPath(uploadPath);
				fFile.setFileType(file.getName().substring(file.getName().lastIndexOf(".")+1));
				
				fFileList.add(fFile);
			}
		}
		
		fileBoard = new FileBoardVO();
		fileBoard.setF_no(Integer.parseInt(multi.getParameter("f_no")));
		fileBoard.setF_title(multi.getXSSParameter("f_title"));
		fileBoard.setF_writer(multi.getXSSParameter("f_writer"));
		fileBoard.setF_content(multi.getParameter("f_content"));
		fileBoard.setfFileList(fFileList);
		
		
		return fileBoard;
	}

}
