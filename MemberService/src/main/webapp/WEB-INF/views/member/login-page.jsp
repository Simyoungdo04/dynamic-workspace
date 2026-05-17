<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<style>
body{
	background : #F4F6F8;
}
.card{
	margin : auto;
	margin-top : 100px;
}
</style>
</head>
<body>
	<c:if test="${not empty errorMsg}">
	    <div class="alert alert-danger error" role="alert">${errorMsg}</div>
	</c:if>
	<div class="card w-50">
	  <div class="card-body">
	    <h5 class="card-title">로그인</h5>
	    <form action="http://localhost:8088/0do/login.do" name="signup" id="signUpForm" method="post">
			<div class="mb-3">
		    		<label for="userId" class="form-label">아이디 입력</label>
		    		<input type="text" class="form-control" 
		    		   	   id="userId" name="userId" required="required" aria-required="true">
		  	</div>
		  	<div class="mb-3">
		    		<label for="userId" class="form-label">비밀번호 입력</label>
		    		<input type="password" class="form-control" 
		    		   	   id="userPwd" name="userPwd" required="required" aria-required="true">
		  	</div>
		  <button type="submit" class="btn btn-primary" id="signup-btn">회원가입</button>
		</form>
	  </div>
	</div>
	
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>