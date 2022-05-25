<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>

alert("수정에 성공했습니다.");   

location.href="<%=request.getContextPath()%>/member/detail.do?id=${id}";



	if(confirm('로그인 사용자의 정보가 수정되었습니다.\n현재 화면을 닫고 새로고침 하시겠습니까?')){
		window.opener.location.reload(true);
		window.close();
	}	



</script>
