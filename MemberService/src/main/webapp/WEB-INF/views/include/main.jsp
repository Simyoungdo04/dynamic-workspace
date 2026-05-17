<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<style>
	body{
		background : #F4F6F8;
	}
	.display-3{
		margin-bottom : 0px;
		margin : auto;
		margin-top : 100px;
		font-weight : 600;
	}
	#searchForm{
		padding : 250px;
		padding-top : 50px;
		padding-bottom : 0px;
		
	}
	.input-group{
		height : 50px;
		
		
	}
	#search{
		width : 100px;
		font-size : 18px;
		font-weight : 600;
		--bs-body-bg : #FDFDFE;
		--bs-body-color : #707B8A;
		color : #707B8A;
		
	}
	.btn-outline-secondary{
		--bs-btn-bg : #DDE3EA;
		--bs-btn-border-color : #707B8A;
		--bs-btn-color : #707B8A;
		--bs-btn-hover-bg : #707B8A;
		--bs-btn-hover-color : #DDE3EA;
		--bs-btn-hover-border-color : #DDE3EA;
		font-size : 18px;
		font-weight : 600;
		width : 75px;
	}
	#title{
		--bs-body-color : #1C2128;
	}
	#util{
		padding-right : 50px;
		padding-top : 30px;
	}
	.btn-outline-primary{
		--bs-btn-border-color : #5B7FA6;
		--bs-btn-color : #5B7FA6;
		--bs-btn-hover-color : #F4F6F8;
		--bs-btn-hover-bg : #5B7FA6;
		--bs-btn-hover-border-color : #5B7FA6;
		--bs-btn-active-bg : #3D5873;
		--bs-btn-active-border-color : #3D5873;
	}
	.btn-primary{
		--bs-btn-bg : #5B7FA6;
		--bs-btn-border-color : #5B7FA6;
		--bs-btn-color : #F4F6F8;
		--bs-btn-hover-color : #F4F6F8;
		--bs-btn-hover-bg : #4A6A8F;
		--bs-btn-hover-border-color : #4A6A8F;
		--bs-btn-active-bg : #3D5873;
		--bs-btn-active-border-color : #3D5873;
	}
	img{
		width : 50px;
		margin-right : 10px;
	}
	.profileBtn{
		border : 0;
		background : none;
	}
</style>

</head>
<body>

<header>
	<div id="util">
		<!-- when if userInfo == null => empty userInfo -->
		<c:choose>
			<c:when test="${ empty userInfo }">
				<div class="d-grid gap-2 d-md-flex justify-content-md-end">
					<button type="button" class="btn btn-outline-primary"
							onclick="location.href='http://localhost:8088/0do/login.do'">로그인</button>
					<button type="button" class="btn btn-primary"
							onclick="location.href='http://localhost:8088/0do/enroll.do'">회원가입</button>
				</div>
			</c:when>
			<c:otherwise>
				<div id="profile" class="d-grid gap-2 d-md-flex justify-content-md-end">
					<button class="profileBtn" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" 
							aria-controls="offcanvasRight">
							<img src="resources/profiles/profileIcon.png">
					</button>
					<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
				    		<div class="offcanvas-header">
				    			<img src="resources/profiles/profileIcon.png">
				    			<p class="fs-5 offcanvas-title" id="offcanvasRightLabel">UserName</p>
				    			<button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
				  		</div>
				  		<div class="offcanvas-body">
				    			<p class="fs-5">userId</p>
				    			<p class="fs-5">email</p>
				    			<p class="fs-5">enrollDate</p>
				    			<button type="button" class="btn btn-primary">로그아웃</button>
				  		</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</header>

<main>
	<section id="title">
		<h1 class="display-3 text-center">Member</h1>
	</section>
	<section id="searchForm">
		<div class="input-group mb-3">
		  <input id="search" type="text" class="form-control" placeholder="이름 검색">
		  <button id="search searchBtn" class="btn btn-outline-secondary" type="button" id="button-addon2">검색</button>
		</div>
	</section>
	<section id="selectUser"></section>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>