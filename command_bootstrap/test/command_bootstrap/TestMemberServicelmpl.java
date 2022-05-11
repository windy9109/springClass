package command_bootstrap;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jsp.dao.MemberDAO;
import com.jsp.dao.MemberDAOImpl;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

public class TestMemberServicelmpl {
	
	private MemberService memberservice = new MemberServiceImpl();

	
	
	@Test
	public void testSelectMemberList()throws Exception{
		List<MemberVO>memberList = memberservice.getMemberList();
		Assert.assertEquals(7, memberList.size());
		
	}
	
	
	
}
