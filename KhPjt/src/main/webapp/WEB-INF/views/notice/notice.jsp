<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<style>
	#table{
		width : 80%;
        margin : auto;
        height : 1200px;
        padding-bottom : 60px;
        margin-top : 100px;
	}
	#notice{
		margin : auto;
		padding-top : 100px;
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
				<tr>
			      <th scope="row">1</th>
			      <td>Mark</td>
			      <td>Otto</td>
			      <td>@mdo</td>
			      <td>@mdo</td>
			    </tr>
			</tbody>
		</table>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>