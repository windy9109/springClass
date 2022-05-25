 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/include/header.jsp" %>
<c:set var="memberList" value="${dataMap.memberList}"/>
<c:set var="pageMaker" value="${dataMap.pageMaker}"/>
<c:set var="cri" value="${pageMaker.getCri()}"/>



<div class="wrapper">
  <div >
	 <!-- Main content -->
	<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>회원목록</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="list.do">
				        	<i class="fa fa-dashboard"></i>회원관리
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	목록
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
	</section>
	 
	 
   	<section class="content">
   		<div class="card">
   			<div class="card-header with-border">
   				<button type="button" class="btn btn-primary" onclick="OpenWindow('registForm.do', '회원등록',800,800)" >회원등록</button>
   				<div id="keyword" class="card-tools" style="width:550px;">
   					 <div class="input-group row">
   					 	<!-- search bar -->
   					 	<!-- sort num -->
					  	<select class="form-control col-md-3" name="perPageNum" 
					  			id="perPageNum" onchange="list_go(1)">					  		  		
					  		<option value="10" ${cri.getPerPageNum() == 10? 'selected':''}>정렬개수</option>
					  		<option value="2" ${cri.getPerPageNum() == 2? 'selected':''}>2개씩</option>
					  		<option value="3" ${cri.getPerPageNum() == 3? 'selected':''}>3개씩</option>
					  		<option value="5" ${cri.getPerPageNum() == 5? 'selected':''}>5개씩</option>
					  	</select>
					  	
					  	<!-- search bar -->
					 	<select class="form-control col-md-3" name="searchType" id="searchType">
					 		<option value=""  >검색구분</option>
							<option value="i" ${param.searchType=='i'? "selected":""}>아이디</option>
							<option value="n"  ${param.searchType=='n'? "selected":""}>이 름</option>
							<option value="p"  ${param.searchType=='p'? "selected":""}>전화번호</option>
							<option value="e"  ${param.searchType=='e'? "selected":""}>이메일</option>				 									
						</select>
						<!-- keyword -->
   					 	<input  class="form-control" type="text" name="keyword" 
										placeholder="검색어를 입력하세요." value="${param.keyword}"/>
						<span class="input-group-append">
							<button class="btn btn-primary" type="button" 
									id="searchBtn" data-card-widget="search" onclick="list_go(1);">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
					<!-- end : search bar -->		
   					 </div>
   				</div>   			
   			</div>
   			<div class="card-body" style="text-align:center;">
    		  <div class="row">
	             <div class="col-sm-12">	
		    		<table class="table table-bordered">
		    			<tr>
		    				<th>사진</th>
		                	<th>아이디</th>
		                	<th>패스워드</th>
		                	<th>이 름</th>
		                	<th>이메일</th>
		                	<th>전화번호</th>
		                	<th>등록날짜</th> <!-- yyyy-MM-dd  -->
		               	</tr>
		            <c:choose>
		            <c:when test="${memberList ne null}">
					<c:forEach items="${memberList}" var="member" varStatus="status">
		     					 <tr onclick="OpenWindow('detail.do?id=${member.id}','회원상세', 700,800);" style="cursor:pointer;">
		            		  	   	<td>
		            		  	   		<span class="manPicture" data-id="${member.id }" style="display:block;width:40px;height:40px;margin:0 auto;"></span>
		            		  	   	</td>
		            		  	   	<td>${member.id }</td>
				              		<td>${member.pwd }</td>
				              		<td>${member.name }
				              		<td>${member.email }</td>
		            		  	   	<td>${member.phone.replace('-','')  }</td>
		            		  	   	<td>${member.regDate }</td>
		            		  	   	<c:out value="${board.title}" />

		            		  	  </tr>	
		     		</c:forEach>
		     		</c:when>
		     		<c:otherwise>
		     			<tr>
	            			<td colspan="7" class="text-center">
	            				해당내용이 없습니다.
	            			</td>
	            		</tr>
		     		</c:otherwise>
		     		</c:choose>

		     			
		     			
		     			
		            </table>
    		     </div> <!-- col-sm-12 -->
    	       </div> <!-- row -->
    		</div> <!-- card-body -->
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
						

	

	<c:set var="pageNum" value="${pageMaker.getCri().getPage()}"/>
	
	<c:forEach var="i" begin="${pageMaker.getStartPage()}" end="${pageMaker.getEndPage()}" step="1" varStatus="status">
	<li class="page-item ${ i == pageNum ? 'active':'' }">
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
	     </div>
   	</section>
  </div>
  
  
  
<form id="jobForm">	
	<input type='hidden' name="page" value="" />
	<input type='hidden' name="perPageNum" value=""/>
	<input type='hidden' name="searchType" value="" />
	<input type='hidden' name="keyword" value="" />
</form>
  
  
  <script>
	function list_go(page,url){
		if(!url) url="list.do";
		
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
  
  
<script>
window.onload =function(){
	MemberPictureThumb('<%=request.getContextPath() %>');
}
</script>


 <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
    <div class="p-3">
      <h5>Title</h5>
      <p>Sidebar content</p>
    </div>
  </aside>
  <!-- /.control-sidebar -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="float-right d-none d-sm-inline">
      Anything you want
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
  </footer>
</div>
<!-- ./wrapper -->


 <%@ include file="/WEB-INF/include/footer.jsp" %>
 
 
 