<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/summernote/summernote-bs4.min.css">
</head>

<title>공지 등록</title>

<body>
 <!-- Main content -->
	<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>공지등록</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="list.do">
				        	<i class="fa fa-dashboard"></i>공지사항
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	등록
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
	</section>
	 
  <!-- Main content -->
    <section class="content container-fluid">
		<div class="row justify-content-center">
			<div class="col-md-9" style="max-width:960px;">
				<div class="card card-outline card-info">
					<div class="card-header">
						<h3 class="card-title p-1">공지등록</h3>
						<div class ="card-tools">
							<button type="button" class="btn btn-primary" id="registBtn" onclick="regist_go();">등 록</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" class="btn btn-warning" id="cancelBtn" onclick="CloseWindow();" >취 소</button>
						</div>
					</div><!--end card-header  -->
					<div class="card-body pad">
						<form role="form" method="post" action="regist.do" name="registForm">
							<div class="form-group">
								<label for="title">제 목</label> 
								<input type="text" id="title"
									name='title' class="form-control" placeholder="제목을 쓰세요">
							</div>							
							<div class="form-group">
								<label for="writer">작성자</label> 
								<input type="text" id="writer" readonly
									name="writer" class="form-control" value="${loginUser.id }">
							</div>
							<div class="form-group">
								<label for="content">내 용</label>
								<textarea class="textarea" name="content" id="content" rows="20"
									cols="90" placeholder="1000자 내외로 작성하세요." ></textarea>
							</div>
						</form>
					</div><!--end card-body  -->
					<div class="card-footer" style="display:none">
					
					</div><!--end card-footer  -->
				</div><!-- end card -->				
			</div><!-- end col-md-12 -->
		</div><!-- end row -->
    </section>
    <!-- /.content -->
    
    <script type="text/javascript">
    	window.onload=function(){
    		$('#content').summernote({
    			placefolder:'여기에 내용을 적으세요',
    			lang:'ko-KR',
    			height:250,
    			disableResizeEditor:true,
    			callbacks:{
    				onUmageUpload: function(files, editor, welEditable) {
    					for(var file of files){
	    					if(file.name.substring(file.name.lastIndexOf(".")+1).toUpperCase() != "JPG"){
	    						alert("jpg형식만 가능합니다.");
	    						return;
	    					}
	    					if(file.size > 1024*1024*5){
	    						alert("이미지는 5MB 미만입니다.");
	    						return;
	    					}
    					}
						
					}
    		
    		
    		
    		
    			}
    			
    		});
    	}
    	</script>
    	
    	<script>
    		function sendFile(file, el){
    			var form_data = new FormData();
    			form_data.append("file", file);
    			$.ajax({
    				url: '<%= request.getContextPath() %>/uploadImg.do',
    				data: form_data,
    				type: "POST",
    				contentType: false,
    				processData: false,
    				success: function(img_url){
    					$(el).summernote('editor.inserImage', img_url);
    				},
    				error: funtion(){
    					alert(file.name+"업로드에 실패했습니다.");
    				}
    			});
    		}
    	</script>



</body>


       