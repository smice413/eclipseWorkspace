<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<ul>
	<core:choose>
		<core:when test="${param.name == 'toto'}">
			<li>당신의 이름은 ${param.name } 입니다.</li>
		</core:when>
		<core:when test="${param.age >= 20 }">
			<li>당신의 나이는 20세 이상 입니다.</li>
		</core:when>
		<core:otherwise>
			<li>당신의 이름은 'toto'가 아니고, 나이는 20세 이상이 아닙니다.</li>
		</core:otherwise>
	</core:choose>

</ul>

</body>
</html>