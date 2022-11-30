<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

처음 작성하는 JSP 프로그램 <br>

application공유 값 : 
<%
	String result = (String)application.getAttribute("test"); 

%>
<%=result %>


</body>
</html>