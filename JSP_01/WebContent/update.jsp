<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
 
<title>Insert title here</title>
<style>
body{
background: #f4f6f9;
text-align: center;
}
 	.button1{
		    background: #89a438;
	    border: 1px solid #6e8c32;
	    color: #fff;
	    font-weight: 600;
	    padding: 15px 20px;
	    border-radius: 5px;
	    width: 100%;
	}
	#form{
		  width: 1200px;
    margin: auto;
    display: inline-block;
    text-align: left;
    margin-top: 50px;
    box-shadow: 0 0 1px rgb(0 0 0 / 13%), 0 1px 3px rgb(0 0 0 / 20%);
    background: #fff;
    border-radius: 10px;
    padding: 50px 50px 100px;
	}
	h1{
	text-align: center;
    letter-spacing: -3px;
    font-weight: 600;
    font-size: 30px;
    padding-top: 100px;
	}
</style>
</head>
<body>
	
	<h1>글 수정하기</h1>
	<form action="Supdate" method="post" class="form-group" id="form" >
		<label for="title">제목</label> <input type="text" name="title" class="form-control"><br/>
		<label for="title">내용</label> 
		<textarea id="story" rows="5" cols="33" name="content" class="form-control"></textarea>
		<input type="hidden" name="bno" value=${bno}><br/>
		<input type="submit" value="수정하기" class="button1"/>
	</form>
</body>
</html>