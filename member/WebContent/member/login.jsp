<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="member" class="member.MemberDTO"/>
<<jsp:setProperty property="*" name="member"/>

<%
	MemberDAO dao = MemberDAO.getInstance();
	int result = dao.memberCheck(member);		// 회원 인증 메소드
	
	if(result == 1){		// 회원인증 성공
		session.setAttribute("id", member.getId()); //세션으로 공유설정
%>		
			<script>
				alert("로그인 성공");
				location.href = "main.jsp";
			</script>
			

		<% }else{  			// 회원인증 실패%>
			<script>
				alert("로그인 실패");
				history.go(-1);
			</script>
<% } %> 