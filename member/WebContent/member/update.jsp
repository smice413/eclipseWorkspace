<%@page import="member.MemberDTO"%>
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

	// 취미를 하이픈(-)을 붙여서 저장 : ex) 공부-게임-등산-
	String h = "";			   // h= "공부-게임-등산-"
	for(String h1 : hobby){
		h += h1 + "-";
	}
	member.setHobby(h);
	
	// 한 사람의 상세정보 구하기
	MemberDAO dao = MemberDAO.getInstance();
	MemberDTO old = dao.getMember(member.getId());
	
	// 비번 비교
	if(old.getPasswd().equals(member.getPasswd())){ // 비번 일치시 //old.getPasswd() : DB에 저장된 비번  member.getPasswd(): 입력한 비번
		int result = dao.update(member); 		//update SQL문 실행
	
		if(result == 1){
%>
		<script>
			alert("회원정보 수정 성공");
			location.href = "main.jsp";
		</script>	
	
	<%}
	}else{ // 비번 불일치 //예외가 발생하면 초기값인 0을 준다.%>
		<script>
			alert("비밀번호가 일치하지 않습니다.");
			history.go(-1);
		</script>	
	<%} %>
	
