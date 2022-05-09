<%@page import="com.jsp.vo.Board"%>
<%@page import="com.jsp.vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>


<style>
body{ background-color: #f4f6f9 !important; }
 	button{
		    background: #89a438;
	    border: 1px solid #6e8c32;
	    color: #fff;
	    font-weight: 600;
	    padding: 15px 20px;
	    border-radius: 5px;
	}

h1{
    padding-top: 40px !important;
    padding-bottom: 40px !important;
    width: 100%;
    border-bottom: 1px solid #999;
    letter-spacing: -4px;
    font-weight: 600 !important;
    font-size: 24px !important;
}
	}
	th{  

.table thead th{
    border-top: 0;
        border-left: 0 !important;
}
.table td, .table th{
    border-left: 0 !important;
}
	}
	td{}
	tr{}
	tbody{}
	.title_t{width: 60%;} 
	.container{	
    padding-bottom: 70px;}
    .table{
        border: 0;
    box-shadow: 0 0 1px rgb(0 0 0 / 13%), 0 1px 3px rgb(0 0 0 / 20%);
    background: #fff;
    }
</style>

  <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  
  
   <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">
  
</head>
<body>



		
<h1 style="text-align:center; padding: 70px; background: #fff;">회원리스트</h1>
<div class="container" style="min-width:1200px;margin:0 auto;">
		<br/>
		<div style="width:100%; margin:0 auto;position:relative;overflow:hidden;">
			<button onclick="location.href='regist'" type="button" style="display:block;float:right;">글쓰기</button>
		</div>
		<br/>
		
		
		
		
		
		
		<table border="1" style="width:100%;margin:0 auto;" class="table table-striped">
		<thead>
			<tr>
				<th class="bno_t">번호</th>
				<th class="title_t">제목</th>
				<th class="regDate_t">날짜</th>
				<th class="viewCnt_t">조회수</th>
				<th class="writer_t">작성자</th>
			</tr>
			</thead>
			<%
				List<Board> boardList = (List<Board>)request.getAttribute("data");
				
				int count = 0;
				if (boardList!=null) for(Board board : boardList){
				pageContext.setAttribute("board", board);
				pageContext.setAttribute("num",count++);
			%>
			<tr style="text-align:center">
				<%-- <td>${num}</td> --%>
				<td class="bno">${board.bno}</td>
				<td class="title" onclick="location.href='Sdetail?bno=${board.bno}'">${board.title }</td>
				<td class="regDate">${board.regDate }</td>
				<td class="viewCnt">${board.viewCnt }</td>
				<td class="writer">${board.writer }</td>

				
			</tr>
			<%		
				}else{
			%>
			<tr >
				<td colspan="3">해당내용이 없습니다.</td>
			</tr>
			<%		
					
				}
			%>
		</table>
</div>
	

	
	
	
	
	
</body>
</html>