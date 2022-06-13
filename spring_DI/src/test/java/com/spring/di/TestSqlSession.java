package com.spring.di;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jsp.dto.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/context/dataSource-context.xml")
public class TestSqlSession {
	
	@Autowired
	private SqlSession session;
	
	@Test
	public void TestGetMember()throws Exception{
		String testID ="mimi";
		MemberVO member = session.selectOne("Member-Mapper.selectMemberById", testID);
		Assert.assertNotNull(member);
	}
	
	@Test
	@Rollback
	public void testInserMember()throws Exception{
		MemberVO member = new MemberVO();
		member.setId("tototo");
		member.setPwd("tototo");
		member.setEmail("tototo");
		member.setName("tototo");
		member.setPhone("010001111");
		member.setPicture("noimage.jpg");
		member.setAuthority("ROLE_USER");
		

		session.update("Member-Mappers.insertMember",member);
		MemberVO result = session.selectOne("Member-Mapper.selectMemberById",member);
		
		Assert.assertNotNull(result);
		
		
	}
	
	
	
//	@Before
//	public void initSession() throws Exception{
//		session = sqlSessionFactory.openSession(true);
//	}
//	
//	@After
//	public void closeSession() throws Exception{
//		if(session != null)session.close();
//	}
	
}
