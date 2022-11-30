<%@ page contentType="text/html;charset=euc-kr"%>

<html>
	<body>
	<h2>포워딩되는 페이지: forwardTo1.jsp</h2>

	<%
		String id = request.getParameter("id");
		String password = request.getParameter("password");
	%>

	<b><%=id%></b>님의<p>
	패스워드는 <b><%=password%></b>입니다.

	 <jsp:forward page="forwardTo2.jsp"/>
	
	<%-- <% response.sendRedirect("forwardTo2.jsp"); %> 
			페이지 이동은 되지만 공유가 되지는 않는다.따라서 값이 넘어가지지 않음.--%>

	</body>
</html>
