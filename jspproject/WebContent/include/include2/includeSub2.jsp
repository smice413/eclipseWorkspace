<%@ page contentType="text/html;charset=euc-kr"%>

<html>
	<body>

	<%
		String siteName = request.getParameter("siteName");
	%>

	includeSub2.jsp 페이지 입니다.<p>

	<b><%=siteName%></b>
	<hr>

	</body>
</html>