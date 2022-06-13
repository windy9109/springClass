package com.jsp.action.board.reply;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.FBReplyRemoveCommand;
import com.jsp.command.PageMaker;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.service.FBReplyService;

public class FBReplyRemoveAction implements Action {
	
	private FBReplyService fBReplyService;
	public void setfBReplyService(FBReplyService fBReplyService) {
		this.fBReplyService = fBReplyService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		FBReplyRemoveCommand removeCMD = HttpRequestParameterAdapter.execute(request, FBReplyRemoveCommand.class);
		
		fBReplyService.removeFBReply(removeCMD.getFb_rno());
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(new Criteria());
		pageMaker.setTotalCount(fBReplyService.getFBReplyListCount(removeCMD.getFb_no()));
		
		int realEndPage = pageMaker.getRealEndPage();
		
		int page = removeCMD.getPage();
		if (page > realEndPage) {
			page = realEndPage;
		}
		
		PrintWriter out = response.getWriter();
		out.print(page);
		out.close();
		
		return url;
	}

}
