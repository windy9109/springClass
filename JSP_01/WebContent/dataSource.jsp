<%@page import="java.text.DecimalFormat"%>
<%@page import="com.jsp.command.PageMaker"%>
<%@page import="java.util.Map"%>
<%@page import="com.jsp.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




<c:set var="dataMap" value="${requestScope.dataMap}"/>
<c:set var="boardList" value="${requestScope.dataMap.get('boardList')}"/>
<c:set var="pageMaker" value="${requestScope.dataMap.get('pageMaker')}"/>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

 <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/dist/css/adminlte.min.css">

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
		
		
		
		   	<div class="card-header with-border">
   				<button onclick="location.href='regist'" type="button">글쓰기</button>
   				<div id="keyword" class="card-tools" style="width:550px;">
   					 <div class="input-group row">
   					 	<!-- search bar -->
   					 	<!-- sort num -->
					  	<select class="form-control col-md-3" name="perPageNum" 
					  			id="perPageNum" onchange="">					  		  		
					  		<option value="10" ${pageMaker.getCri().getPerPageNum() == 10? 'selected':''}>정렬개수</option>
					  		<option value="2" ${pageMaker.getCri().getPerPageNum() == 2? 'selected':''}>2개씩</option>
					  		<option value="3" ${pageMaker.getCri().getPerPageNum() == 3? 'selected':''}>3개씩</option>
					  		<option value="5" ${pageMaker.getCri().getPerPageNum() == 5? 'selected':''}>5개씩</option>
					  	</select>
					  	
					  	<!-- search bar -->
					 	<select class="form-control col-md-3" name="searchType" id="searchType">
					 		<option value=""  >검색구분</option>
							<option value="i" ${param.searchType=='i'? "selected":""}>아이디</option>
							<option value="n" ${param.searchType=='n'? "selected":""}>이 름</option>
							<option value="p" ${param.searchType=='p'? "selected":""}>전화번호</option>
							<option value="e" ${param.searchType=='e'? "selected":""}>이메일</option>				 									
						</select>
						<!-- keyword -->
   					 	<input  class="form-control" type="text" name="keyword" 
										placeholder="검색어를 입력하세요." value="${param.keyword}"/>
						<span class="input-group-append">
							<button class="btn btn-primary" type="button" 
									id="searchBtn" data-card-widget="search" onclick="list_go(-1);">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
					<!-- end : search bar -->		
   					 </div>
   				</div>   			
   			</div>
   			
   			
   			
   			
		
		
		
		
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
			<c:choose>
			<c:when test="${boardList ne null}">
			<c:forEach items="${boardList}" var="board" varStatus="status">
				<tr style="text-align:center">
					<td class="bno">${board.bno}</td>
					<td class="title" onclick="location.href='Sdetail?bno=${board.bno}'">${board.title }</td>
					<td class="regDate">${board.regDate }</td>
					<td class="viewCnt">${board.viewCnt }</td>
					<td class="writer">${board.writer }</td>
				</tr>
			</c:forEach>
			</c:when>
			<c:otherwise>
				<tr >
					<td colspan="3">해당내용이 없습니다.</td>
				</tr>
			</c:otherwise>
			</c:choose>
		</table>
</div>




    		<div class="card-footer">
    			<!-- pagination -->
    			<nav aria-label="Navigation">
					<ul class="pagination justify-content-center m-0">
						<li class="page-item">
							<a class="page-link" href="javascript:list_go(1);">
								<i class="fas fa-angle-double-left"></i>
							</a>
						<li class="page-item">
							<a class="page-link" href="">
								<i class="fas fa-angle-left"></i>
							</a>						
						</li>
						

<c:set var="startPage" value="${pageMaker.getStartPage()}"/>
<c:set var="endPage" value="${pageMaker.getEndPage()}"/>
<c:set var="pageNum" value="${pageMaker.getCri().getPage()}"/>

<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
	<li class="page-item  ${ i==pageNum? 'active':''}">
		<a class="page-link" href="javascript:list_go(${i});">${i}</a>
	</li>	
</c:forEach>
						
						
						<li class="page-item">
							<a class="page-link" href="">
								<i class="fas fa-angle-right"></i>
							</a>						
						</li>
						<li class="page-item">
							<a class="page-link" href="">
								<i class="fas fa-angle-double-right"></i>
							</a>						
						</li>
					</ul>
				</nav>
    		</div>
    		
    		
    		
    		
 <form id="jobForm">	
	<input type='hidden' name="page" value="" />
	<input type='hidden' name="perPageNum" value=""/>
	<input type='hidden' name="searchType" value="" />
	<input type='hidden' name="keyword" value="" />
</form>
  
  
  <script>
	function list_go(page,url){
/* 		alert(page)
		alert(url) */
		//alert(page);
 		if(!url) url="dataSource";
		
		var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val(page);
		jobForm.find("[name='perPageNum']").val($('select[name="perPageNum"]').val());
		jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
		jobForm.find("[name='keyword']").val($('div.input-group>input[name="keyword"]').val());
		
		
		jobForm.attr({
			action:url,
			method:'get'
		}).submit(); 
		
	}
  </script>
  
     		
    		
	

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/resources/bootstrap/dist/js/adminlte.min.js"></script>	
	
	
	
	
</body>
</html>