package kr.or.ddit.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.File;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.command.MemberRegistCommand;
import com.jsp.command.SearchCriteria;
import com.jsp.controller.MakeFileName;
import com.jsp.dto.MemberVO;
import com.jsp.dto.NoticeVO;
import com.jsp.service.LoginSearchMemberService;
import com.jsp.service.NoticeService;

import kr.or.ddit.command.MemberModifyCommand;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping("/main")
	public String main() {
		String url = "member/list";
		return url;
	}

	@RequestMapping("/list")
	public String list(SearchCriteria cri, Model model) throws SQLException {
		String url = "notice/list";

		Map<String, Object> dataMap = noticeService.getNoticeList(cri);
		model.addAttribute("dataMap", dataMap);

		return url;
	}
	
	
	

	@RequestMapping("/registForm")
	public String registForm() {
		String url = "notice/regist";
		return url;
	}
	
	

	@RequestMapping("/regist")
	public String regist(NoticeVO notice, HttpServletRequest request, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/notice/list";

		//notice.setTitle((String)request.getAttribute("XSStitle"));
		
		noticeService.regist(notice);
		rttr.addFlashAttribute("from","regist");
		
		return url;
	}
	

	@RequestMapping("/detail")
	public ModelAndView detail(int nno, @RequestParam(defaultValue="") String from,HttpServletRequest request, ModelAndView mnv) throws Exception {

		String url = "notice/detail";
		NoticeVO notice =null;
		
		MemberVO member = null;
		if(!from.equals("list")) {
			notice = noticeService.getNoticeForModify(nno);
		}else {
			notice =  noticeService.getNotice(nno);
			url="redirect:/notice/detail.do?nno="+nno;
		}
		
		mnv.addObject("notice",notice);
		mnv.setViewName(url);
		
		return mnv;
	}

	
	
	@RequestMapping("/modifyForm")
	public ModelAndView modifyForm(int nno, ModelAndView mnv) throws Exception {

		String url = "notice/modify";

		NoticeVO notice = noticeService.getNoticeForModify(nno);
		mnv.addObject("notice",notice);
		mnv.setViewName(url);
		return mnv;
	}
	
	
	
	
	

//	@Autowired
//	MemberRestController restController;
//	
//	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPost(NoticeVO notice, HttpServletRequest request, 
									RedirectAttributes rttr) throws Exception {

		String url = "redirect:/notice/detail.do";

		noticeService.modify(notice);

		//notice.setTitle(HTMLInputFilter.htmlSpecialChars(notice.getTitle()));
		notice.setTitle((String)request.getAttribute("XSStitle"));
		
		rttr.addAttribute("nno", notice.getNno());
		rttr.addFlashAttribute("from","modify");
		
		return url;
	}

	
//	@Resource(name = "picturePath")
//	private String picturePath;
//	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(int nno, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/notice/detail.do";
		
		noticeService.remove(nno);
	
		rttr.addFlashAttribute("from","remove");
		rttr.addAttribute("nno", nno);
		
		return url;
	}
}









