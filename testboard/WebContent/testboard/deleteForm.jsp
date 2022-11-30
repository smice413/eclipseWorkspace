<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="testboard.BoardDTO" %>
<%@page import="testboard.BoardDAO" %>

<%
	int no = Integer.parseInt(request.getParameter("no"));
	String pageNum = request.getParameter("pageNum");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글삭제</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/board.js"></script>
</head>
<body>

<form method=post action=deletePro.jsp>
	<input type=hidden name=no value="<%=no%>">
	<input type=hidden name=pageNum value="<%=pageNum%>">
	<table border=1 width=500 align=center>
		<caption>글 삭 제</caption>		
		<tr><td>비밀번호</td>
				<td><input type=password id=passwd name=passwd></td>
		</tr>		
		<tr><td colspan=2 align=center>
					<input type=submit value="삭제">
					<input type=reset value="취소">
				</td>
		</tr>
	</table>

</form>



</body>
</html>