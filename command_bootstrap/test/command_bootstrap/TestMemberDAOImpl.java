package command_bootstrap;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.dao.MemberDAO;
import com.jsp.dao.MemberDAOImpl;
import com.jsp.datasource.OracleMybatisSqlSessionFactory;
import com.jsp.dto.MemberVO;

public class TestMemberDAOImpl {
	
	private OracleMybatisSqlSessionFactory sqlSessionFactory =
			new OracleMybatisSqlSessionFactory();
	
	private SqlSession session;
	
	private MemberDAO memberDAO = new MemberDAOImpl();
	
	@Before
	public void init()throws Exception{
		session = sqlSessionFactory.openSession();
		
	}
	
	@Test
	public void testSelectMemberList()throws Exception{
		List<MemberVO>memberList = memberDAO.selectMemberList(session);
		Assert.assertEquals(7, memberList.size());
		
	}
	
	
	
	
	@After
	public void close()throws Exception{
		if(session != null ) session.close();
	}
	
}
