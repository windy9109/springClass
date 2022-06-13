<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert('로그인에 성공했습니다.');
	location.href='<%=request.getContextPath()%>/board/file/list.do';
</script>    