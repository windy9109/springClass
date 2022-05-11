package com.jsp.datasource;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.vo.BoardVO;



public class TestOracleMybatisSqlSessionFactry {
	
	private OracleMybatisSqlSessionFactory sqlSessionFactory =
			new OracleMybatisSqlSessionFactory();
	
	private SqlSession session;
	
	@Before
	public void init()throws Exception{
		session = sqlSessionFactory.openSession();
		
	}
	
	@Test
	public void testSqlSessionFactry()throws SQLException{
		Assert.assertNotNull(sqlSessionFactory);
	}
	
	@Test
	public void testSqlSession()throws SQLException{
		Collection<String> mapNames =
		(Collection<String>)session.getConfiguration().getMappedStatementNames();
		//Assert.assertNotNull(sqlSessionFactory);
		Assert.assertNotNull(mapNames.contains("Member-Mapper.selectboardList"));
		//if(true) throw new Exception();
	}
	
	
	@Test
	public void testMemberList()throws SQLException{
		List<BoardVO>memberList = session.selectList("Member-Mapper.selectboardList");
		Assert.assertEquals(7, memberList.size());
		
	}
	
	
	@After
	public void close()throws Exception{
		if(session != null ) session.close();
	}
	

}
