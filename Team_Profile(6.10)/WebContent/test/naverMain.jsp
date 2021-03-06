<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- <link rel="shortcut icon" type="image/x-icon" href="/img/ko/favicon.ico">
<link rel="icon" type="image/x-icon" href="/img/ko/favicon.ico"> -->
<title>Clover</title>

<!-- CSS -->
<link rel="stylesheet" href="./css/ko/navercorp.css?20220510">
<link rel="stylesheet" href="./css/scrollText.css">

<!-- JS -->
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript" src="./js/swiper.min.js"></script>
<script type="text/javascript" src="./js/wcslog.js"></script>
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
			src: url('./css/font/NanumBarunGothic.eot');
			src: url('./css/font/NanumBarunGothic.eot') format('embedded-opentype'),url('./css/font/NanumBarunGothic.woff') format('woff');}


.gnb_menu .gnb_menu_item {
	font-family: 'NanumBarunGothic', 'serif';
	font-size: 25px;
    font-weight: bold;
	
  	/* font-family: 'Noto Sans KR', sans-serif; */ 
  /* font-family: 'Noto Serif KR', serif; */
}
.gnb_dropMenu_item{
	font-family: 'NanumBarunGothic', 'serif';
}

</style>

</head>
<body>
<!-- header -->
<script type="text/javascript">

$(document).ready(function(){
	$('.gnb_menu').delegate('.gnb_menu_list', 'mouseenter', function(){
		$(this).find('.gnb_dropMenu_wrap').stop().slideDown(500);
	});
	$('.gnb_menu').delegate('.gnb_menu_list', 'focusin', function(){
		$(this).find('.gnb_dropMenu_wrap').stop().slideDown(500);
	});
	$('.gnb_menu').delegate('.gnb_menu_list', 'mouseleave', function(){
		$(this).find('.gnb_dropMenu_wrap').stop().slideUp(250);
	});
	$('.gnb_menu').delegate('.gnb_menu_list', 'focusout', function(){
		$(this).find('.gnb_dropMenu_wrap').stop().slideUp(250);
	});
	
	$('.btn_sitemap').click(function() {
		$(this).attr("aria-expanded", true);
		$('header').toggleClass('active');
	});
	
	
	var didScroll;
	var lastScrollTop = 0;
	var delta = 5;
	var navbarHeight = $('header').outerHeight();
	
	$(window).scroll(function(event){
	    didScroll = true;
	});
	setInterval(function(){
	    if(didScroll){
	        hasScrolled();
	        didScroll = false;
	    }
	}, 250);
	function hasScrolled(){
	    var st = $(this).scrollTop();
	
	    if(Math.abs(lastScrollTop - st) <= delta)
	    return;
	    if(st > lastScrollTop && st > navbarHeight){
	        $('header').removeClass('header_down').addClass('header_up');
	    }else{
	        if(st + $(window).height() < $(document).height()){
	            $('header').removeClass('header_up').addClass('header_down');
	        }
	    }
	    lastScrollTop = st;
	}
});
</script>

<!-- header -->
<!-- [D] scroll up ???, ?????? ??????, ??????????????? ?????? // .btn_sitemap ?????? ???, active????????? ?????? -->
<header class="">

	<div class="header_wrap">
		<h1 class="header_logo">
			<a href="#"><span class="blind">Clover</span></a>
		</h1>
		<nav>
			<ul class="gnb_menu" role="menu">
				<!-- .gnb_menu_list ????????? ???, on????????? ?????? // .gnb_menu_list??? ??????, ????????? ???, .gnb_menu_item??? aria-expanded="true" // .gnb_dropMenu_wrap slideUp, Down -->
				<li class="gnb_menu_list " role="menuitem" aria-haspopup="true">
					<a href="/naver/company" aria-expanded="false" class="gnb_menu_item">About</a>
					<ul class="gnb_dropMenu_wrap">
						<li>
							<ul class="gnb_dropMenu">
								<li class="depth_blank">
									<a href="#" class="gnb_dropMenu_item"><strong><span>Team ProFile Project ??????</span></strong></a>
								</li>
								<li>
									<a href="#" class="gnb_dropMenu_item"><span class="depth">??????</span></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>??? ??????</span></strong></a>
								</li>
								<li>
									<a href="#" class="gnb_dropMenu_item"><span class="depth">?????? ??????</span></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li class="depth_blank">
									<a href="#" class="gnb_dropMenu_item"><strong><span>?????????</span></strong></a>
								</li>
								<li>
									<a href="#" class="gnb_dropMenu_item"><span class="depth">?????????</span></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="/naver/contact" class="gnb_dropMenu_item"><strong><span>?????????</span></strong></a>
								</li>
							</ul>
						</li>
					</ul>
				</li>
				
		
				<li class="gnb_menu_list " role="menuitem" aria-haspopup="true">
					<a href="#" aria-expanded="false" class="gnb_menu_item">Member</a>
					<ul class="gnb_dropMenu_wrap">
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>?????????</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>?????????</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>?????????</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>?????????</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>?????????</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>?????????</span></strong></a>
								</li>
							</ul>
						</li>
					</ul>
				</li>
	
	
				<li class="gnb_menu_list " role="menuitem" aria-haspopup="true">
					<a href="#" aria-expanded="false" class="gnb_menu_item">Board</a>
					<ul class="gnb_dropMenu_wrap">
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>????????? ??????</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>?????????</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>?????? ?????????</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>?????? ??????</span></strong></a>
								</li>
							</ul>
						</li>
					</ul>
				</li>
				
				<li class="gnb_menu_list " role="menuitem" aria-haspopup="true">
					<a href="#" aria-expanded="false" class="gnb_menu_item">?????? ????????????</a>
					<ul class="gnb_dropMenu_wrap">
						<li>
							<ul class="gnb_dropMenu">
								<li class="depth_blank">
									<a href="#" class="gnb_dropMenu_item"><strong><span>Final Project</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li class="classify">
									<a href="#" class="gnb_dropMenu_item"><strong><span>????????? </span></strong></a>
								</li>
								<li class="classify">
									<a href="#" class="gnb_dropMenu_item"><strong><span>???????????? ?????????</span></strong></a>
								</li>
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>?????? ?????????</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li class="depth_blank">
									<a href="#" class="gnb_dropMenu_item"><strong><span>??????</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li class="depth_blank">
									<a href="#" class="gnb_dropMenu_item"><strong><span>?????? ???????????? ?????????</span></strong></a>
								</li>
								<li>
									<a href="#" class="gnb_dropMenu_item"><span class="depth">?????? ??????</span></a>
								</li>
								<li>
									<a href="#" class="gnb_dropMenu_item"><span class="depth">?????? ??????</span></a>
								</li>
								<li>
									<a href="#" class="gnb_dropMenu_item"><span class="depth">????????????</span></a>
								</li>
							</ul>
						</li>
						
					</ul>
				</li>
			</ul>
		</nav>
	</div>
		
</header>
<!-- //header -->


</body>
</html>
