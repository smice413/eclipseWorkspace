<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	String writer = request.getParameter("writer");
	String passwd = request.getParameter("passwd");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	String contents= request.getParameter("content").replace("\n", "<br>"); //\n을 <br>태그로 치환하고 그것을 contents변수에 저장해라.
%>

작성자 : <%=writer%> <br>
비밀번호 : <%=passwd%> <br>
제목 : <%=subject %> <br>
내용01 : <pre><%=content %></pre> <br>
내용02 : <br><%=contents %>
		<%-- 글작성 내용 줄바꿔서 출력하는 방법1: pre태그는 textarea에 쓰인 내용이 줄이 바뀐대로 출력되도록 하게 한다.
		           글작성 내용 줄바꿔서 출력하는 방법2: 스크립틀릿태그 하나 추가하고 그값에.replace("\n", "<br>") 메소드로 치환하는 법.      
		--%>