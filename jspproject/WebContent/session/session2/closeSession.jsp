<%@ page contentType = "text/html; charset=euc-kr" %>

<%
    session.invalidate(); //세션 삭제: 로그아웃, 회원탈퇴
%>

<html>
	<head><title>세션 종료</title></head>
	<body>
	<script>
		alert("로그아웃");
		location.href = "../../index.jsp";
	</script>

	세션을 종료하였습니다.

	</body>
</html>