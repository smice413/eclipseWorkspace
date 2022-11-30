<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!-- uri 경로를 ctrl+스페이스바를 누르고 core로 끝나는 것을 선택하면됨. 이 경로를 불러와야 태그를 사용할 수 있다. -->

<c:set var="num1" value="${20}" /> <!-- value="${20}"이것을 value="20"으로 해도 같다. -->
<c:set var="num2">
10.5
</c:set>
<c:set var="today" value="<%= new java.util.Date() %>" />

<html>
	<head>
		<title>set 태그와 remove 태그</title>
	</head>

	<body>
		<%
			String str = "JSP변수";
			request.setAttribute("st", str);
		%>
		변수 : str1 = <%=str%> <br> <!-- 표현식 태그 안에 일반적으로 정의된 변수 넣으면 출력잘됨. -->	
		변수 : str2 = ${str}   <br> <!-- 표현언어로 안에 일반적으로 정의된 변수를 넣으면 출력안됨. set태그로 정의된 변수는 가능. 그냥 변수를 넣으려면 공유설정을 해야함 -->	
		변수 : str3 = ${st}    <br> <!-- str변수를 st라는 name변수로 공유하여 표현언어에 넣으면 출력잘됨. -->
		<%
			String s = (String) request.getAttribute("st");		
		%>
		변수 : str4 = <%=s %> <br>
		
		
		변수 num1 = ${num1} <br> <!-- set태그로 정의된 변수. 출력 잘됨. -->
		변수 num2 = ${num2} <br>
		num1 + num2 = ${num1 + num2} <br>
		오늘은 ${today} 입니다.

		<c:remove var="num1" scope="page" /><!-- scope의 기본 영역은 page이다. -->

		<p>
		삭제한 후의 num1 = ${num1} <br>
		삭제한 후의 num1 + num2 = ${num1 + num2}
	</body>
</html>
