<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<h1>상세보기</h1>
		아이디 : ${ id }
		패스워드 : ${ pwd }
		<div style="">
			<button onclick="location.href='Supdate?id=${ id }&pwd=${ pwd }';" type="button" style="display:block;float:left;">수정</button>
			<button onclick="location.href='Sdelete?id=${ id }';" type="button" style="display:block;float:left;">삭제</button>
		</div>
</body>
</html>