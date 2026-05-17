<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	#table{
		width : 80%;
        margin : auto;
        height : 300px;
        padding-bottom : 60px;
        margin-top : 100px;
	}
	.table{
		--bs-table-bg: #fefefe;
		border-color : #cccccc;
		--bs-table-color : #252525;
	}
	#notice{
		margin : auto;
		padding-top : 100px;
	}
	a{
		color : #252525;
	}
	#buttons{
        margin : auto;
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
</style>
</head>
<body>
	<figure class="text-center">
  		<blockquote class="blockquote">
    		<h2 id="notice">공지사항</h2>
  		</blockquote>
	</figure>
	<div id="table">
		<table class="table table-hover">
			<thead>
			    <tr>
			      <th scope="col">No</th>
			      <th scope="col">작성자</th>
			      <th scope="col">제목</th>
			      <th scope="col">작성일</th>
			      <th scope="col">조회수</th>
			    </tr>
			</thead>
			<tbody>
				<c:choose>
                 	<c:when test="${ empty notices }">
               			<tr>
               				<th colspan="5">조회 결과가 존재하지 않습니다.</th>
               			</tr>
                 	</c:when>
                 	<c:otherwise>
               			<c:forEach var="notice" items="${ notices }">
	                 			<tr onclick="location.href='http://localhost:8088/kh/detail.no?noticeNo=${ notice.noticeNo }'"
	                 					style="cursor:pointer;">
							    	<th scope="row">${ notice.noticeNo }</th>
							        <td>${ notice.userName }</td>
							        <td>${ notice.noticeTitle }</td>
							        <td>${ notice.createDate }</td>
							        <td>${ notice.count }</td>
				    			</tr>
		    			</c:forEach>
			    	</c:otherwise>
		    	</c:choose>
			</tbody>
		</table>
	</div>
	<div id="buttons">
		<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
		  <div class="btn-group me-2" role="group" aria-label="First group">
		  	<c:if test="${ pi.startPage ne 1 }">
		    	<button type="button" class="btn btn-dark"
		    			onclick="location.href='http://localhost:8088/kh/notice.do?page=${pi.startPage-1}'">···</button>
		    </c:if>
		  	<c:if test="${ pi.currentPage ne 1 }">
		    	<button type="button" class="btn btn-dark"
		    			onclick="location.href='http://localhost:8088/kh/notice.do?page=${ pi.currentPage-1 }'">←</button>
		  	</c:if>
		  	<c:forEach var="i" begin="${ pi.startPage }" end="${ pi.endPage }">
		    	<button type="button" class="btn btn-light"
		    			onclick="location.href='http://localhost:8088/kh/notice.do?page=${i}'">${ i }</button>
		   	</c:forEach>
		   	<c:if test="${ pi.currentPage ne pi.maxPage }">
		    	<button type="button" class="btn btn-dark"
		    			onclick="location.href='http://localhost:8088/kh/notice.do?page=${ pi.currentPage+1 }'">→</button>
		    </c:if>
		    <c:if test="${ pi.endPage ne pi.maxPage }">
		    	<button type="button" class="btn btn-dark"
		    			onclick="location.href='http://localhost:8088/kh/notice.do?page=${pi.endPage+1}'">···</button>
		    </c:if>
		  </div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>