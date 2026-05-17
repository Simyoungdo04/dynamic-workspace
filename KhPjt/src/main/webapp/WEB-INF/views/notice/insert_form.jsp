<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<style>
	body{
		background : #fefefe;
		color : #252525;
	}
	#noticeForm{
		margin : auto;
		padding-top : 100px;
	}
	#input{
		margin : auto;
		width : 60%;
	}
	input{
		--bs-body-color : #252525;
		--bs-border-color : #252525;
		--bs-body-bg : #fefefe;
	}
	textarea{
		--bs-body-bg : #fefefe;
		--bs-border-color : #252525;
		--bs-body-color: #252525;
		resize : none;
	}
</style>
</head>
<body>
	<figure class="text-center">
 		<blockquote class="blockquote">
   			<h2 id="noticeForm">공지사항 작성</h2>
 		</blockquote>
	</figure>
	<div id="input">
		<div class="mb-3">
	 		<label class="form-label">제목</label>
	  		<input type="text" class="form-control">
		</div>
		<div class="mb-3">
	  		<label class="form-label">내용</label>
	  		<textarea class="form-control" rows="15"></textarea>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>