<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	
	<h1>welcomeFile</h1>
	
	<h2>* EL (Expression Language)</h2>
	
	<p>
		JSP상에서 자바에서 만들어진 값을 출력하고 싶다면 => &lt;%= 변수 %> <br>
		EL구문을 사용하면 \${ 변수 } 형식으로 작성할 수 있음
	</p>
	
	<h3>EL구문</h3>
	
	<a href="http://localhost:8088/action/el.do">서블릿으로 요청</a>
	
	<hr>
	
	sessionScope : ${ academy } <br>
	requestScope : ${ classRoom } <br>	
	
	<hr>
	
	<!-- 
		JSP를 이루는 구성요소
		
		1. Scripting Element : JSP상에서 자바 코드를 직접 기술할 수 있게 해주는 요소
		2. 문자열 : HTML, CSS, J.S
		3. 지시어 : JSP페이지 정보를 기술한다거나(page), 포함시킬 떄 사용(include)
		4. JSP Action Tag : XMl기술을 사용해서 기존의 JSP문법을 확장하는 용도의 태그들
	-->
	 
	<h2>* JSP Action Tag</h2>
	 
	<h3>1. 표준 액션 태그</h3>
	
	<a href="http://localhost:8088/action/include.do">include.do</a>
	<hr>
	
	<a href="http://localhost:8088/action/forward.do">더 좋은 액션 태그</a>
	<hr>
	
	<h3>2. 커스텀 액션 태그</h3>
	
	<a href="/action/jstl.do">JSTL</a>
	
</body>
</html>











