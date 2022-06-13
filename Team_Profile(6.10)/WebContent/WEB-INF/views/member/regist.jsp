<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <head>
	<style>
	.mainText{
		margin-top: 8px;
		text-align: center;
	}
	
	.login-box, .register-box {
	    width: 500px;
	}
	body{
		margin: 10px 50px 10px 50px;"
	}
	</style>  
	
	
  </head>

  <title>회원가입</title>
  
<body class="hold-transition register-page" style="margin: 10px 0px 10px 50px;"">

<div class="register-box">
  <div class="card card-outline card-primary">
    <div class="card-header text-center">
      <a href="#" class="h1"><b>Clover&nbsp;</b>&nbsp;회원가입</a>
    </div>
    
    <div class="card-body">
    <form role="form" class="form-horizontal" action="regist.do" method="post">
	    <input type="hidden" name="picture" />
		<div class="input-group">
			<div class="mailbox-attachments clearfix" style="text-align: center; width: 100%;">
				<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div>
					<div class="mailbox-attachment-info">
						<div class="input-group input-group-sm">
							<label for="inputFile" class=" btn btn-warning btn-sm btn-flat input-group-addon">파일선택</label>
							<input id="inputFileName" class="form-control" type="text" name="tempPicture" disabled /> 
							<span class="input-group-append-sm">
								<button type="button" class="btn btn-info btn-sm btn-append" onclick="upload_go();">업로드</button>
							</span>
						</div>
					</div>
				</div>
			<br />
		</div>
		<p class="login-box-msg">새 회원으로 등록하세요!</p>

        <div class="input-group mb-3">
        <label for="id" class="col-sm-3 mainText" style="font-size:0.9em;" >
							 	<span style="color:red;font-weight:bold;">*&nbsp;</span>아이디</label>
          <input name="id" onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣]/g, &#39;&#39;);"
								type="text" class="form-control" id="id" placeholder="13글자 영문자,숫자 조합">
          <div class="input-group-append">
            <span class="input-group-append">
				<button type="button" onclick="idCheck_go();"  class="btn btn-info btn-sm btn-append">중복확인</button>
			</span>	
          </div>
        </div>
        <div class="input-group mb-3">
        <label for="pwd" class="col-sm-3 mainText" style="font-size:0.9em;">
			<span style="color:red;font-weight:bold;">*&nbsp;</span>비밀번호</label>
          <input type="password" name="pwd" class="form-control" placeholder="20글자 영문자,숫자,특수문자 조합">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
        <label for="pwdCheck" class="col-sm-3 mainText" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*&nbsp;</span>비밀번호 확인</label>
          <input type="password" class="form-control" placeholder="비밀번호를 재입력">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
        <label for="name" class="col-sm-3 mainText" style="font-size:0.9em;">
				<span style="color:red;font-weight:bold;">*&nbsp;</span>이 름</label>
          <input type="text" name="name" class="form-control" placeholder="이름을 입력하세요">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
		<div class="form-group row">
			<label for="authority" class="col-sm-3 mainText" style="font-size: 0.9em;">권한</label>
			<div class="col-sm-9">
				<select name="authority" class="form-control" style="font-size: 0.9em;">
					<option value="ROLE_USER">사용자</option>
					<option value="ROLE_MANAGER">운영자</option>
					<option value="ROLE_ADMIN">관리자</option>
				</select>
			</div>
		</div>
		
		<div class="input-group mb-3">
		  <label for="email" class="col-sm-3 mainText" style="font-size:0.9em;">이메일</label>
          <input type="email" class="form-control" name="email" placeholder="Email">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
		<div class="form-group row">
			<label for="phone" class="col-sm-3 control-label mainText">전화번호</label>
			<div class="col-sm-9">
				<div class="input-group-sm">
					<select style="width: 100px; text-align:center;" name="phone" id="phone"
						class="form-control float-left">
						<option value="">-선택-</option>
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="017">017</option>
						<option value="018">018</option>
					</select> 
					<label class="float-left"	style="padding: 0; text-align: center;">&nbsp;&nbsp;-&nbsp;&nbsp;</label> 
					<input style="width: 100px;" name="phone" type="text" class="form-control float-left" /> 
					<label class="float-left" style="padding: 0; text-align: center;">&nbsp;&nbsp;-&nbsp;&nbsp;</label> 
					<input style="width: 100px;" name="phone" type="text" class="form-control float-right" />
				</div>
			</div>
		</div>
		<div class="row">
          <div class="col-8">
            <div class="icheck-primary" style="transform: translateY(70%);text-align: center;">
              <input type="checkbox" id="agreeTerms" name="terms" value="agree">
              <label for="agreeTerms">
               	약관에 <a href="#">동의합니다.</a>
              </label>
            </div>
          </div>
          <!-- /.col -->
          <div class="col-4">
            <button type="button" onclick="regist_go();" class="btn btn-block btn-outline-primary btn-sm">등록</button>
            <button type="button" onclick="CloseWindow();" class="btn btn-block btn-outline-secondary btn-sm">취소</button>
          </div>
          <!-- /.col -->
        </div>
      </form>

      <div class="social-auth-links text-center">
        <a href="#" class="btn btn-block btn-primary">
          <i class="fab fa-facebook mr-2"></i>
          Sign up using Facebook
        </a>
        <a href="#" class="btn btn-block btn-danger">
          <i class="fab fa-google-plus mr-2"></i>
          Sign up using Google+
        </a>
      </div>

      <a href="#" class="text-center">이미 아이디가 있습니다!</a>
    </div>
    <!-- /.form-box -->
  </div><!-- /.card -->
</div>
<!-- /.register-box -->

<form role="imageForm" action="upload/picture" method="post" enctype="multipart/form-data">
	<input id="inputFile" name="pictureFile" type="file" class="form-control" style="display:none;" onchange="picture_go();">
	<input id="oldFile" type="hidden" name="oldPicture" value="" />
	<input type="hidden" name="checkUpload" value="0" />	
</form>

<!-- REQUIRED SCRIPTS -->
<script>
function picture_go(){
	//alert("file change");
	
   var form = $('form[role="imageForm"]');
   var picture = form.find('[name=pictureFile]')[0];
   
   //이미지 확장자 jpg 확인
   var fileFormat = picture.value.substr(picture.value.lastIndexOf(".")+1).toUpperCase();
	if(!(fileFormat=="JPG" || fileFormat=="JPEG")){
   		alert("이미지는 jpg/jpeg 형식만 가능합니다.");
   		picture.value="";      
   		return;
	} 

	//이미지 파일 용량 체크
   if(picture.files[0].size>1024*1024*1){
      alert("사진 용량은 1MB 이하만 가능합니다.");
      picture.value="";
      return;
   }
	// 업로드 확인변수 초기화(사진변경)
   form.find('[name="checkUpload"]').val(0);
   document.getElementById('inputFileName').value = picture.files[0].name;
   
    //javaScript에서는 값이 들어가 있지 않으면 false / 있으면 ture를 반환
   if(picture.files && picture.files[0]){ 
	   var reader = new FileReader();
	   
	   reader.onload = function (e){
		   $('div#pictureView').css({'background-image' : 'url('+e.target.result+')',
			   						 'background-position' : 'center',
			   						 'background-size' : 'cover',
			   						 'background-repeat' : 'no-repeat'});
	   }
	   reader.readAsDataURL(picture.files[0]);
   }
}

function upload_go(){
	//alert("upload btn click");
	if(!$('input[name="pictureFile"]').val()){
		alert("사진을 선택하세요.");
		$('input[name="pictureFile"]').click();
		return;
	}
	if($('input[name="checkUpload"]').val() == 1){
		alert("이미 업로드 된 사진입니다.");
		return;
	}
	
	var formData = new FormData($('form[role="imageForm"]')[0]);
	
	$.ajax({
		url:"picture.do",
		data:formData,
		type:"post",
		processData:false,
		contentType:false,
		success:function(data){
			// 업로드 확인변수 세팅
			$('input[name="checkUpload"]').val(1);
			// 저장된 파일명 저장.
			$('input#oldFile').val(data); // 변경시 삭제될 파일명
			$('form[role="form"] input[name="picture"]').val(data);
			alert("사진이 업로드 되었습니다.");
		},
		error:function(error){
			alert("현재 사진 업로드가 불가합니다. \n 관리자에게 연락바랍니다.")
		}
	});
}

var checkedID = "";
function idCheck_go(){
	//alert("id check btn click");
	
	var input_ID= $('input[name="id"]');
	
	if(!input_ID.val()){
		alert("아이디를 입력하세요.");
		input_ID.focus();
		return;
	}
	
	$.ajax({
		url : "idCheck.do?id="+ input_ID.val().trim(),
		method : "get",
		success : function(result){
			if(result.toUpperCase() == "DUPLICATED"){
				alert("중복된 아이디 입니다.");
				$('input[name="id"]').focus();
			}else{
				alert("사용가능한 아이디 입니다.");
				checkedID = input_ID.val().trim();
				$('input[name="id"]').val(input_ID.val().trim());
			}
		},
		error:function(error){
			alert('시스템 장애로 확인이 불가합니다.')
		}
	})
	
}

function regist_go(){
	//alert("regist btn click");
	var uploadCheck = $('input[name="checkUpload"]').val();
	 if(uploadCheck == "0"){
		 alert("사진 업로드는 필수 입니다.");
		 return;
	 }
	 if(!$('input[name="id"]').val()){
		 alert("아이디는 필수 입니다.");
		 return;
	 }
	 if($('input[name="id"]').val() != checkedID){
		 alert("아이디는 중복 확인이 필요합니다.");
		 return;
	 }
	 if(!$('input[name="pwd"]').val()){
		 alert("패스워드는 필수 입니다.");
		 return;
	 }
	 if(!$('input[name="name"]').val()){
		 alert("이름은 필수 입니다.");
		 return;
	 }
	 
	 var form = $('form[role="form"]');
	 form.attr({"method" : "post",
	 			"action" : "regist.do"
	 		});
	 form.submit();
}


</script>

