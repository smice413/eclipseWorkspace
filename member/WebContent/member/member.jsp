<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="member" class="member.MemberDTO"/>
<jsp:setProperty property="*" name="member"/>

<%
	String[] hobby = request.getParameterValues("hobby");
	String h = "";
	for(String h1 : hobby){
		h += h1 + "-";		// h= "공부-게임-등산-" //한개의 컬럼에 값을 계속 누적시켜 저장시키기 위함. 이렇게 하지 않으면 한개의 값밖에 저장 못함.
	}

	member.setHobby(h);		// 위에 누적된 값을들 객체에 강제로 저장시킴.
	
	// DAO 객체 생성
	MemberDAO dao = MemberDAO.getInstance();
	int result = dao.insert(member); // insert SQL문 실행할 메소드 호출
	
	if(result == 1){		// 회원가입 성공
%>		
		<script>
			alert("회원가입 성공");
			location.href="loginform.html";
		</script>
	<%}else{				// 회원가입 실패%>				
		<script>
			alert("회원가입 실패");
			history.go(-1);
		</script>
	<%}%>
%>    