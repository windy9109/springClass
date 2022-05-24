package com.jsp.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.MemberModfiyCommand;
import com.jsp.command.MemberRegistCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;

public class MemberModifyAction2 implements Action {

	private MemberService memberService;
	public void setSearchMemberService(MemberService memberService) {
		this.memberService=memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		//화면
		String id = request.getParameter("id");
		String url="/member/modify_success";
				
		//입력
		try {
			
			request.setCharacterEncoding("utf-8");
			
			MemberModfiyCommand command = HttpRequestParameterAdapter.execute(request,
					MemberModfiyCommand.class );
			MemberVO member = command.toMemberVO();
					
			//처리
			memberService.modify2(member);
			request.setAttribute("id", id);
		
		}catch(Exception e) {
			e.printStackTrace();
			//exception 처리.....
			url="/member/modify_fail";
		}
		
		return url;
	}

}
