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
	#wrap{
		margin: auto;
		width : 60%;
	}
	#noticeForm{
		margin-top : 30px;
	}
	#notice{
		margin-top : 30px;
	}
	.card{
		height : 650px;
		--bs-card-border-color : #cccccc;
		border : 0;
	}
	.card-header, .card-body{
		background-color: #fefefe;
		color : #252525;
	}
	.fs-3, .fs-5, .fs-6{
		margin:0
	}
	#userNm{
		font-weight : 600;
	}
	#noticeInfo{
		margin : 0;
		font-size : 12px;
	}
	.btn-dark{
		color : #fefefe;
		--bs-btn-bg : #252525;
		--bs-btn-hover-bg : #444444;
		--bs-btn-hover-border-color : #444444;
		--bs-btn-hover-color: #ffffff;
		--bs-btn-border-color: #252525;
	}
	.btn-light{
		color : #252525;
		--bs-btn-hover-border-color : #252525;
		--bs-btn-hover-bg : #cfcfcf;
		--bs-btn-bg : #fefefe;
		--bs-btn-border-color: #fefefe;
	}
	#del-btn{
		&:hover{
			color : red;
		}
	}
	.return{
		margin-right : auto;
	}
</style>
</head>
<body>
	<div id="wrap">
		<figure class="text-center">
	 		<blockquote class="blockquote">
	   			<h2 id="noticeForm">공지사항</h2>
	 		</blockquote>
		</figure>
		<div class="card" id="notice">
		  <div class="card-header">
		    <p class="fs-3">${ notice.noticeTitle }</p>
		    <p class="fs-6" id="userNm">${ notice.userName }</p>
		    <p id="noticeInfo">${ notice.createDate } | 조회 ${ notice.count }</p>
		  </div>
		  <div class="card-body">
		    <p class="fs-5">${ notice.noticeContent }</p>
		  </div>
		</div>
		<div id="buttons">
			<div class="gap-2 d-md-flex justify-content-md-end">
				<button type="button" class="btn btn-light return">돌아가기</button>
				<button type="button" class="btn btn-light">수정</button>
				<button type="button" class="btn btn-dark" id="del-btn">삭제</button>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>