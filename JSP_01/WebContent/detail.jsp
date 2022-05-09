<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	
   <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">
  
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
background: #f4f6f9;
}
.rap_box{      width: 1200px;
    margin: auto;
    display: inline-block;
    text-align: left;
    margin-top: 50px;
    box-shadow: 0 0 1px rgb(0 0 0 / 13%), 0 1px 3px rgb(0 0 0 / 20%);
    background: #fff;
    border-radius: 10px;
    padding: 50px 50px 100px;
        }
    
.box{ }
.bno{}
.regDate{}
.title{         border-top: 1px solid rgba(0,0,0,.125);
    padding-top: 30px;     padding-bottom: 10px; }
.content{}
.viewCnt{}
.writer{}
.box_s{ padding-bottom: 20px;
    display: inline-block; }
.button2{
    text-align: center;
    padding-top: 100px;
}
.b{
    float: left;
    margin-right: 20px;
}
.button1{
		    background: #89a438;
    border: 1px solid #6e8c32;
    color: #fff;
    font-weight: 600;
    padding: 15px 20px;
    border-radius: 5px;
    width: 300px;
    margin-left: 30px;
	}
.rap1{
text-align: center;
}
</style>

</head>
<body>
<div class="rap1">
	<div class="rap_box card">
		<h1>상세보기</h1>
		<div class="box">
			<div class="box_s">
				<div class="b">게시글번호 : ${ bno }</div>
				<div class="b">조회수 : ${ viewCnt }</div>
				<div class="b">작성자 : ${ writer }</div>
				<div class="b">날짜 : ${ regDate }</div>
			</div>
			<div class="title">제목 : ${ title }</div>
			<div class="content">내용 : ${ content }</div>
			
		</div>
		<div class="button2">
			<button onclick="location.href='Supdate?bno=${ bno }';" type="button"  class="button1">수정</button>
			<button onclick="location.href='Sdelete?bno=${ bno }';" type="button"  class="button1">삭제</button>
		</div>
	</div>
</div>
</body>
</html>