package com.jsp.action.fileboard;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.FileUploadResolver;
import com.jsp.controller.GetUploadPath;
import com.jsp.controller.XSSMultipartHttpServletRequestParser;
import com.jsp.dto.FFileVO;
import com.jsp.dto.FileBoardVO;
import com.jsp.exception.NotMultipartFormDataException;
import com.jsp.service.FileBoardService;

public class FileBoardRegistAction implements Action {
	
	private FileBoardService fileBoardService;
	public void setFileBoardService(FileBoardService fileBoardService) {
		this.fileBoardService = fileBoardService;
	} 
	
	// 1. 입력 : commons-fileupload.jar 패키지를 이용하여 fileItem 형태로 변화된 Muitipart
	// 받아 PdsVO를 완성함.
	// 업로드 파일 환경 설정
	final private int MEMORY_THRESHOLD = 1024*1024*3; // 3MB
	final private int MAX_FILE_SIZE = 1024*1024*40; // 40MB
	final private int MAX_REQUEST_SIZE = 1024*1024*200; // 200MB
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/file/regist_success";
		
		XSSMultipartHttpServletRequestParser multi = null;
		List<FFileVO> fFileList = null;
		
		try {
			multi = new XSSMultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
			
			String uploadPath = GetUploadPath.getUploadPath("fileBoard.upload");
			
			List<File> fileList = FileUploadResolver.fileUpload(multi.getFileItems("uploadFile"), uploadPath);
			
			//List<File> -> List<AttachVO>
			if(fileList != null) {
				fFileList = new ArrayList<FFileVO>();
				for(File file : fileList) {
					FFileVO fFile = new FFileVO();
					// DB에 저장할 attach에 file 내용 추가
					fFile.setFileName(file.getName());
					fFile.setUploadPath(uploadPath);
					fFile.setFileType(file.getName().substring(file.getName().lastIndexOf(".")+1));
					
					fFileList.add(fFile);
				}
			}
		} catch (NotMultipartFormDataException e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		//DB처리
		FileBoardVO fileBoard = new FileBoardVO();
		fileBoard.setF_title(multi.getXSSParameter("title"));
		fileBoard.setF_content(multi.getParameter("content"));
		fileBoard.setF_writer(multi.getXSSParameter("writer"));
		fileBoard.setfFileList(fFileList);
		
		try {
			fileBoardService.regist(fileBoard);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return url;
	}

}
