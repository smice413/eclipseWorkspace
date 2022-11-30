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
<title>상세 페이지</title>
</head>
<body>

<table border=1 width=500 align=center>
		<caption>상세 페이지</caption>
		<tr><td>작성자</td>
				<td><%=board.getWriter() %></td>
		</tr>		
		<tr><td>제목</td>
				<td><%=board.getSubject() %></td>
		</tr>
		<tr><td>내용</td>
				<td><pre><%=board.getContent() %></pre></td>	
		</tr>
		<tr><td colspan=2 align=center>
					<input type=button value="수정" onClick="location.href='updateForm.jsp?no=<%=board.getNo()%>&pageNum=<%=pageNum%>' ">
					<input type=button value="삭제" onClick="location.href='deleteForm.jsp?no=<%=board.getNo()%>&pageNum=<%=pageNum%>' ">
				</td>
		</tr>
	</table>

</body>
</html>