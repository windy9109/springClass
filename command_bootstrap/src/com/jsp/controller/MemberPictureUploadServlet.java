package com.jsp.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import com.jsp.exception.NotMultipartFormDataException;

/**
 * Servlet implementation class MemberPictureUploadServlet
 */
@WebServlet("/member/picture")
public class MemberPictureUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//
	private static final int MEMORY_THRESHOLD = 1024 *500; //500KB
	private static final int MAX_FILE_SIZE = 1024 *1024 *1; //1MB
	private static final int MAX_REQEST_SIZE= 1024*1024*2; //2MB
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url =null;
		try {
			//1. request 변환
			MultipartHttpServletRequestParser multi =
			new MultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQEST_SIZE);
			
			//2.저장할 경로
			String uploadPath = GetUploadPath.getUploadPath("member.picture.upload");
			
			//3. 업로드된 이미지저장
			FileItem[] items = multi.getFileItems("pictureFile");
			List<File> uploadFiles = FileUploadResolver.fileUpload(items, uploadPath);
			String uploadFileName = uploadFiles.get(0).getName();
			//FileUploadResolver.fileUpload(items, uploadPath);
			
			
			//4. 이전이미지 삭제
			String oldPicture = multi.getParameter("oldPicture");
			//multi.getParameter("oldPicture"); 이전이미지 파라미터
			File oldFile = new File(uploadPath+File.pathSeparator+oldPicture);
			if(oldFile.exists()) {
				oldFile.delete();
			}
			
			
			//5. 저장한 파일명보내기
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(uploadFileName);
			
		} catch (NotMultipartFormDataException e) {
			response.sendError(response.SC_BAD_REQUEST);//400
		}catch(Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);//500
		}
		
	}

}
