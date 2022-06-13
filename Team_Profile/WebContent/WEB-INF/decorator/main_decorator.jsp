<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>   
 
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

	<title><decorator:title default="Clover's Webpage"/></title>

	<!-- CSS -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/ko/navercorp.css?20220510">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/scrollText.css">
	
	
	<!-- GNB 관련 JS -->
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/swiper.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/wcslog.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/common.js"></script>
	
	<script type="text/javascript">

	if(!wcs_add) var wcs_add = {};
	wcs_add["wa"] = "f02f8b0d5ad73";
	wcs_do();
	
	var reqnUrl = window.location.pathname;
	if(reqnUrl.indexOf('investment')>-1){
		if(!wcs_add) var wcs_add = {};
		wcs_add["wa"] = "1268406c2d270f";
		wcs_do();
	}
	
	
	</script>
	
	<style type="text/css">
	@font-face { font-family: 'NanumBarunGothic';
				src: url('<%=request.getContextPath() %>/resources/css/font/NanumBarunGothic.eot');
				src: url('<%=request.getContextPath() %>/resources/css/font/NanumBarunGothic.eot') format('embedded-opentype'),url('<%=request.getContextPath() %>/resources/css/font/NanumBarunGothic.woff') format('woff');}
				
	
	.gnb_menu .gnb_menu_item {
		font-family: 'NanumBarunGothic', 'serif';
		font-size: 25px;
	    font-weight: bold;
	}
	.gnb_dropMenu_item{
		font-family: 'NanumBarunGothic', 'serif';
	}
	
	.main-footer {
	    background-color: #fff;
	    border-top: 1px solid #dee2e6;
	    color: #869099;
	    padding: 1rem;
	    max-width: 1280px;
	}
	
	.header_wrap{
		background-color: #fff;
	    color: #1f2d3d;
	}
	
	#mainDecoratorBody { 
		background:#F4F4F4;
		overflow:hidden;
	}
	
	</style>
  
  
  <decorator:head/>


</head>
<body id="mainDecoratorBody">

<div class="wrapper">

<%@ include file="./main/header.jsp" %>

<decorator:body/>

<%@ include file="./main/footer.jsp" %>
	
</div>



<script>
	$('div.wrapper').css({
		"max-width":"1280px",
		"margin":"0 auto"		
	});
</script>
<script>
function goPage(url){
	//alert(url);
	$('iframe[name="ifr"]').attr("src",url);
	
/* 	// HTML5 지원브라우저에서 사용 가능
	if(typeof(history.pushState) == 'function'){
		// 현재 주소를 가져온다.
		var renewURL = location.href;
		// 현재 주소 중 .do 뒤 부분이 있다면 날려버린다.
		renewURL = renewURL.substring(0, renewURL.indexOf(".do") + 3);
		
		if(mCode != 'M000000'){
			renewURL += '?mCode=' + mCode;
		}
		// 페이지를 리로드하지 않고 페이지 주소만 변경할 때 사용
		// null이 위치한 곳은 제목을 주는 곳
		history.pushState(mCode, null, renewURL);
		
	} else{
		location.hash = "#" + mCode;
	} */
}
</script>  

</body>
</html>