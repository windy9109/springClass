<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>

alert("수정에 성공했습니다.");
window.opener.location.href="<%=request.getContextPath()%>/member/list.do";
window.close();
</script>