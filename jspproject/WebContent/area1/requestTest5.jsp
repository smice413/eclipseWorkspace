<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
pageContext.setAttribute("pageScope", "pageValue");
request.setAttribute("requestScope", "requestValue");
%>
<jsp:forward page="requestTest5Result.jsp"></jsp:forward>
</body>
</html>
<%--  <jsp:forward page="">: 다른 페이지로 전달하는 태그. 따라서 request공유영역이 다른 페이지까지 확장됨  --%>