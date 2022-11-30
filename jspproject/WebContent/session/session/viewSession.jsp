<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="java.util.*" %>

<html>
	<head><title>세션 사용 예제</title></head>
	<body>

<%--	// 열거형 : "id", "passwd"
	Enumeration attr = session.getAttributeNames(); //session의 속성명을 모를때사용

	while(	attr.hasMoreElements()	){ //가져올 값이 있으면 true
		String attrName = (String)attr.nextElement(); //object형으로 리턴함
		String attrValue = (String)session.getAttribute(attrName);//다운캐스팅
		out.println("세션의 속성명은 " + attrName + " 이고 ");
		out.println("세션의 속성값은 " + attrValue + "이다.<br><br>");
	}
--%>

<%
	String id = (String)session.getAttribute("id");
	String passwd = (String)session.getAttribute("passwd");
%>

ID : <%=id %> <br>
비밀번호 : <%=passwd %> <br>

	</body>
</html>
