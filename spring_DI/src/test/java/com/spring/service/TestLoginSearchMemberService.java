package com.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/context/root-context.xml")
public class TestLoginSearchMemberService {
	//등록된 bean의 이름으로 가져옴
	@Resource(name="loginSearchMemberService")
	private MemberService memberService;
	
	
	@Test
	public void testGetMemberList()throws Exception{
		
		SearchCriteria cri = new SearchCriteria();
		cri.setKeyword("m");
		cri.setSearchType("i");
		cri.setPage(1);
		cri.setPerPageNum(10);
		
		
		List<MemberVO> memberList =  (List<MemberVO>)memberService.getMemberListForPage(cri).get("memberList");
		
		System.out.println(memberList);
		
	}
	

}
