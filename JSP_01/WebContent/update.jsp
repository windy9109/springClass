<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>글 수정하기</h1>
	<form action="Supdate" method="post" >
		아이디 : <input type="text" name="id" value=${id} readonly><br/>
		패스워드 : <input type="password" name="pwd" /><br/>
		<input type="submit" value="수정하기" />
	</form>
</body>
</html>