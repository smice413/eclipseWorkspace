<%@ page contentType="text/html; charset=euc-kr" %>

<html>
	<head><title>세션 사용 예제</title>
	</head>
	<body>

<%
	String id = "guardian23";
	String passwd = "1234";
	
	// 세션 설정(공유 설정)
	session.setAttribute("id", id); 		//id = "guardian23"
	session.setAttribute("passwd", passwd); // passwd = "1234"
%>

	세션에 id 와 passwd 속성을 설정하였습니다.<br><br>

	<input type="button" value="세션의 설정된 속성확인" onclick="javascript:window.location='viewSession.jsp'">
	</body>
</html>