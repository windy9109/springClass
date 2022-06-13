<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<!-- [D] scroll up 시, 상단 고정, 슬라이드로 노출 // .btn_sitemap 클릭 시, active클래스 추가 -->
<header class="">

	<div class="header_wrap">
		<h1 class="header_logo">
			<a href="javascript:goPage('<%=request.getContextPath() %>/main/test.do')"><span class="blind">Clover</span></a>
		</h1>
		<nav>
			<ul class="gnb_menu" role="menu">
				<!-- .gnb_menu_list 활성화 시, on클래스 추가 // .gnb_menu_list에 호버, 포커스 시, .gnb_menu_item의 aria-expanded="true" // .gnb_dropMenu_wrap slideUp, Down -->
				<li class="gnb_menu_list " role="menuitem" aria-haspopup="true">
					<a href="javascript:goPage('<%=request.getContextPath() %>/about/test.do')" aria-expanded="false" class="gnb_menu_item">About</a>
					<ul class="gnb_dropMenu_wrap">
						<li>
							<ul class="gnb_dropMenu">
								<li class="depth_blank">
									<a href="#" class="gnb_dropMenu_item"><strong><span>Team ProFile Project 소개</span></strong></a>
								</li>
								<li>
									<a href="#" class="gnb_dropMenu_item"><span class="depth">연혁</span></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>팀 소개</span></strong></a>
								</li>
								<li>
									<a href="#" class="gnb_dropMenu_item"><span class="depth">소개 내용</span></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li class="depth_blank">
									<a href="#" class="gnb_dropMenu_item"><strong><span>미구현</span></strong></a>
								</li>
								<li>
									<a href="#" class="gnb_dropMenu_item"><span class="depth">미구현</span></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="/naver/contact" class="gnb_dropMenu_item"><strong><span>미구현</span></strong></a>
								</li>
							</ul>
						</li>
					</ul>
				</li>
				
		
				<li class="gnb_menu_list " role="menuitem" aria-haspopup="true">
					<a href="javascript:window.open('<%=request.getContextPath() %>/test/Personal/memberMain.jsp')" aria-expanded="false" class="gnb_menu_item">Member</a>
					<ul class="gnb_dropMenu_wrap">
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>이슬기</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>이병진</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>곽성상</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>오혜지</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="javascript:goPage('<%=request.getContextPath() %>/member/test.do')" class="gnb_dropMenu_item"><strong><span>김기웅</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>김민지</span></strong></a>
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
									<a href="javascript:goPage('<%=request.getContextPath() %>/board/study/list.do')" class="gnb_dropMenu_item"><strong><span>스터디 내용</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="javascript:goPage('<%=request.getContextPath() %>/board/meeting/list.do')" class="gnb_dropMenu_item"><strong><span>회의록</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="javascript:goPage('<%=request.getContextPath() %>/board/notice/list.do')" class="gnb_dropMenu_item"><strong><span>공지사항</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li>
									<a href="javascript:goPage('<%=request.getContextPath() %>/board/file/list.do')" class="gnb_dropMenu_item"><strong><span>자료 공유</span></strong></a>
								</li>
							</ul>
						</li>
					</ul>
				</li>
				
				<li class="gnb_menu_list " role="menuitem" aria-haspopup="true">
					<a href="javascript:goPage('<%=request.getContextPath() %>/final/main.do')" aria-expanded="false" class="gnb_menu_item">Final Project</a>
					<ul class="gnb_dropMenu_wrap">
						<li>
							<ul class="gnb_dropMenu">
								<li class="depth_blank">
									<a href="javascript:goPage('<%=request.getContextPath() %>/final/main.do')" class="gnb_dropMenu_item"><strong><span>최종 프로젝트</span></strong></a>
								</li>
								
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li class="classify">
									<a href="#" class="gnb_dropMenu_item"><strong><span>산출물 </span></strong></a>
								</li>
								<li class="classify">
									<a href="#" class="gnb_dropMenu_item"><strong><span>요구사항 정의서</span></strong></a>
								</li>
								<li>
									<a href="#" class="gnb_dropMenu_item"><strong><span>화면 정의서</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li class="depth_blank">
									<a href="javascript:goPage('http://localhost/Team_Profile/gantt/tests/test01.jsp')" class="gnb_dropMenu_item"><strong><span>일정</span></strong></a>
								</li>
							</ul>
						</li>
						<li>
							<ul class="gnb_dropMenu">
								<li class="depth_blank">
									<a href="#" class="gnb_dropMenu_item"><strong><span>기타 프로젝트 자료실</span></strong></a>
								</li>
								<li>
									<a href="#" class="gnb_dropMenu_item"><span class="depth">참고 자료</span></a>
								</li>
								<li>
									<a href="#" class="gnb_dropMenu_item"><span class="depth">착수 발표</span></a>
								</li>
								<li>
									<a href="#" class="gnb_dropMenu_item"><span class="depth">최종발표</span></a>
								</li>
							</ul>
						</li>
						
					</ul>
				</li>
			</ul>
		</nav>
		<div class="header_util">
			<div class="header_lang" role="listbox">
				<a href="javascript:OpenWindow('common/loginForm.do','로그인',560,600);" role="option" aria-selected="true">로그인</a>
				<a href="javascript:OpenWindow('member/registForm.do','회원등록',560,900);" role="option" aria-selected="true">회원가입</a>
			</div>			
		</div>
	</div>
		
</header>
<!-- //header -->




