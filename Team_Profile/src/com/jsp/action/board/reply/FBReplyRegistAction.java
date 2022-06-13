package com.jsp.action.board.reply;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dto.FBReplyVO;
import com.jsp.service.FBReplyService;

public class FBReplyRegistAction implements Action {
	
	private FBReplyService fBReplyService;
	public void setfBReplyService(FBReplyService fBReplyService) {
		this.fBReplyService = fBReplyService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		ObjectMapper mapper = new ObjectMapper();
		FBReplyVO reply = mapper.readValue(request.getReader(), FBReplyVO.class);
		
		reply.setFb_rtext(HTMLInputFilter.htmlSpecialChars(reply.getFb_rtext()));
		
		try {
			fBReplyService.registFBReply(reply);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
			return url;
		}
		
		int realEndPage = 1;
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(new Criteria());
		pageMaker.setTotalCount(fBReplyService.getFBReplyListCount(reply.getFb_no()));
		
		realEndPage = pageMaker.getRealEndPage();
		
		PrintWriter out =response.getWriter();
		out.println(realEndPage);
		
		out.close();
		
		
		
		return url;
	}

}
