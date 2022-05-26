package com.jsp.action.common;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsp.action.Action;
import com.jsp.dto.MenuVO;
import com.jsp.service.MenuService;

public class SubMenuAction implements Action {
	
	
	private MenuService menuService;
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		String mCode = request.getParameter("mCode");
		List<MenuVO> subMenu = null;
		
		if(mCode ==null) mCode="M000000";
		
		try {
			
			subMenu = menuService.getSubMenuList(mCode);			
			//request.setAttribute("subMenuList", subMenuList);
			
			//출력
			ObjectMapper mapper = new ObjectMapper();
			
			//content Type 결정
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			//내보내기
			out.print(mapper.writeValueAsString(subMenu));
			
			//out 객체를 종료하고 환원.
			out.close();
			
			// iframe 상태유지
			MenuVO menu = menuService.getMenuByMcode(mCode);
			request.setAttribute("menu", menu);
			
		} catch (SQLException e) {
			e.printStackTrace();
			// Exception 처리 : log 기록...
			throw e;
		}

		return url;
	}

}
