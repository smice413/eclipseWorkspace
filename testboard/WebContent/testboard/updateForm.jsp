<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="testboard.BoardDTO" %>
<%@page import="testboard.BoardDAO" %>

<%
	int no = Integer.parseInt(request.getParameter("no"));
	String pageNum = request.getParameter("pageNum");
	
	BoardDAO manager = BoardDAO.getInstance();
	BoardDTO board = manager.getContent(no);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/board.js"></script>
</head>
<body>

<form method=post action=updatePro.jsp>
	<input type=hidden name=no value="<%=board.getNo()%>">
	<input type=hidden name=pageNum value="<%=pageNum%>">
	<table border=1 width=500 align=center>
		<caption>글 수 정</caption>
		<tr><td>작성자</td>
				<td><input type=text id=writer name=writer value="<%=board.getWriter()%>"></td>
		</tr>		
		<tr><td>비밀번호</td>
				<td><input type=password id=passwd name=passwd></td>
		</tr>
		<tr><td>제목</td>
				<td><input type=text id=subject name=subject value="<%=board.getSubject()%>"></td>
		</tr>
		<tr><td>내용</td>
				<td><textarea cols=50 rows=10 id=content name=content><%=board.getContent() %></textarea></td>	
		</tr>
		<tr><td colspan=2 align=center>
					<input type=submit value="수정">
					<input type=reset value="취소">
				</td>
		</tr>
	</table>

</form>



</body>
</html>