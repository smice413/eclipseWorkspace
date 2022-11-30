<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.Enumeration"%>
<html>
<head>
<title>Attribute Test</title>
</head>
<body>
<h2>영역과 속성 테스트</h2>
<table border="1">
	<tr><td colspan="2">Application 영역에 저장된 내용들</td></tr>
	<tr>
		<td>이름</td>
		<td><%=application.getAttribute("name") %></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><%=application.getAttribute("id") %></td>
	</tr>
</table>
<br>
<table border="1">
	<tr><td colspan="2">Session 영역에 저장된 내용들</td></tr>
<%-- <%
//공유되는 값을 알지 못할 때 열거형으로 처리한다.
Enumeration e=session.getAttributeNames(); //email, address, tel
while(e.hasMoreElements()){ //값이 있으면 true로 실행문 실행
	String attributeName=(String)e.nextElement(); //나열된 순서대로 값을 가져오겠다는 의미
	String attributeValue=(String)session.getAttribute(attributeName);
	%>
	<tr>
		<td><%=attributeName %></td>
		<td><%=attributeValue %></td>
	</tr>
	<%
}
%> --%>

<!-- 공유되는 값을 알때 이렇게 처리함. -->
	<tr>
		<td>email</td>
		<td><%=session.getAttribute("email") %></td>
	</tr>
	<tr>
		<td>tel</td>
		<td><%=session.getAttribute("tel") %></td>
	</tr>
	<tr>
		<td>address</td>
		<td><%=session.getAttribute("address") %></td>
	</tr>
		

</table>
</body>
</html>
