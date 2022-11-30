<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String) session.getAttribute("id"); // 다운캐스팅(Object->String)

	if(id != null){ // 세션이 있는 경우
		
%>
	<%=id %>님 환영 합니다. <br><br><br>
	
	<a href = "updateform.jsp">정보 수정</a><br>
	<a href = "logout.jsp">로그 아웃</a><br>
	<a href = "deleteform.jsp">회원 탈퇴</a><br>
	
	
	<%}else{		// 세션이 없는 경우 //main.jsp로 실행시킬 경우%>
	
	<a href = "memberform.html">회원 가입</a><br>
	<a href = "loginform.html">로그인</a><br>
	
	<%} %>
