package com.jsp.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.command.MemberModfiyCommand;
import com.jsp.command.MemberRegistCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;

public class MemberRemoveAction implements Action {
	
	private MemberService memberService;
	public void setSearchMemberService(MemberService memberService) {
		this.memberService=memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//화면
		String url="/member/remove_success";
		MemberVO member = null;
				
		//입력
		try {
			
			request.setCharacterEncoding("utf-8");
			
			MemberModfiyCommand command = HttpRequestParameterAdapter.execute(request,
					MemberModfiyCommand.class );
			member = command.toMemberVO();
					
			//처리
			memberService.remove(member.getId());
		
		}catch(Exception e) {
			e.printStackTrace();
			//exception 처리.....
			url="/member/remove_fail";
		}
		
		
		// DB처리
		memberService.remove(member.getId());
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if (loginUser!=null && member.getId().equals(loginUser.getId())) {
			session.invalidate();
		}
		
		request.setAttribute("member", member);
		
		return url;
		
	}
}
