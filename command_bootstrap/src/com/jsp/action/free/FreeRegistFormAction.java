package com.jsp.action.free;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;

public class FreeRegistFormAction implements Action {

	@Override
	public String process(HttpServletRequest request, 
						  HttpServletResponse response) throws Exception {
		String url ="/board/regist";
		return url;
	}

}
