<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>JSTL core 라이브러리 사용 예제 2</title>
</head>
<body>
	<c:forEach var="test" begin="1" end="10" step="2">
		<b>${test}</b>&nbsp; <!-- &nbsp; 숫자와 숫자 사이에 여백을 만들어줌 -->
</c:forEach>
	<br>
	<c:forTokens var="alphabet" items="a,b,c,d,e,f,g,h,i,j,k,l,m,n"
		delims=",">
		<b>${alphabet}</b>&nbsp;
</c:forTokens>
	<br>
	<c:set var="data" value="홍길동,김길동,고길동" />
	<c:forTokens var="varData" items="${data}" delims=",">
		<b>${varData}</b>&nbsp;
</c:forTokens>
</body>
</html>
