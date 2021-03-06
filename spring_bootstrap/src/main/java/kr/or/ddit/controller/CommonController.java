package kr.or.ddit.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.MemberVO;
import com.jsp.dto.MenuVO;
import com.jsp.dto.NoticeVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIdException;
import com.jsp.service.LoginSearchMemberService;
import com.jsp.service.MenuService;


@Controller
public class CommonController {
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private LoginSearchMemberService MemberService;
	
	
	@RequestMapping("/main")
	public String main() {
		String url = "home";
		return url;
	}
	
	
	@RequestMapping("/index")
	public String indax(@RequestParam(defaultValue = "M000000")String mCode, Model model) throws SQLException {
		String url = "common/indexPage";
		
		List<MenuVO> menuList = menuService.getMainMenuList();
		MenuVO menu = menuService.getMenuByMcode(mCode);
		
		model.addAttribute("menuList", menuList);
		model.addAttribute("menu", menu);

		return url;
	}
	
	
	
	
	
	@RequestMapping(value= "/common/loginForm", method=RequestMethod.GET)
	public String loginForm(@RequestParam(defaultValue = "")String error, HttpServletResponse response) {
		String url = "/common/loginForm";
		if(error.equals("-1")) {
			response.setStatus(302);
		}
		
		return url;
	}
	
	
	@RequestMapping(value= "/common/login", method=RequestMethod.POST)
	public String login(String id, String pwd, HttpSession session) throws Exception {
		String url = "redirect:/index.do";

		//notice.setTitle((String)request.getAttribute("XSStitle"));
		
		try {
			MemberService.login(id, pwd);
			session.setAttribute("loginUser", MemberService.getMember(id));
		} catch (NotFoundIdException | InvalidPasswordException e) {
			url="common/login_fail";
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		
		return url;
	}
	
	
	@RequestMapping(value= "/common/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		String url = "redirect:/";
		session.invalidate();
		return url;
	}
	
	
	@RequestMapping("/subMenu")
	public ResponseEntity<List<MenuVO>> subMenuToJSON(String mCode, HttpServletRequest request, RedirectAttributes rttr, Model model) throws Exception {
		ResponseEntity<List<MenuVO>> entity = null;
		List<MenuVO> subMenu = null;
		
		try {
			subMenu = menuService.getSubMenuList(mCode);
			entity = new ResponseEntity<List<MenuVO>>(subMenu, HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<List<MenuVO>>( HttpStatus.INTERNAL_SERVER_ERROR);;
			e.printStackTrace();
		}

		
		return entity;
	}
	
	

}
