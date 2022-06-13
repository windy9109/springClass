package com.jsp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.jsp.dto.FFileVO;

public class MakeFileName {
	
	public static String toUUIDFileName(String fileName, String delimiter) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid + delimiter + fileName;
	}
	
	public static String parseFileNameFromUUID(String fileName, String delimiter) {
		String[] uuidFileName = fileName.split(delimiter);
		return uuidFileName[uuidFileName.length -1];
	}
	
	public static List<FFileVO> parseFileNameFromFFiles(List<FFileVO> fFileList,String delimiter){
		List<FFileVO> renamedFFileList = new ArrayList<FFileVO>();
		
		if(fFileList != null) {
			for(FFileVO fFile : fFileList) {
				String fileName = fFile.getFileName();
				fileName = parseFileNameFromUUID(fileName, delimiter);
				//fileName
				fFile.setFileName(fileName);
				
				renamedFFileList.add(fFile);
			}
		}
		return renamedFFileList;
	}
}
