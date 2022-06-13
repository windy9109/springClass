package com.jsp.action.board.reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.action.Action;
import com.jsp.dto.FBReplyVO;
import com.jsp.service.FBReplyService;

public class FBReplyModifyAction implements Action {
	
	private FBReplyService fBReplyService;
	public void setfBReplyService(FBReplyService fBReplyService) {
		this.fBReplyService = fBReplyService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		ObjectMapper mapper = new ObjectMapper();
		FBReplyVO reply = mapper.readValue(request.getReader(), FBReplyVO.class);
		
		//XSS
		reply.setFb_rtext(HTMLInputFilter.htmlSpecialChars(reply.getFb_rtext()));
		
		try {
			fBReplyService.modifyFBReply(reply);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
			// TODO: handle exception
		}
		
		return url;
	}

}
