<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String id = request.getParameter("id");
	System.out.println("id="+ id); //ajax는 오류를 확인 하기 어려워서 중간 중간에 진행이 잘 되는지 확인하기 위함 console창으로 확인
	
	MemberDAO dao = MemberDAO.getInstance();
	int result = dao.memberAuth(id);
	System.out.println("result="+ result);
//	result : 1 (중복ID)
// 	result : -1(사용가능한 ID)
	
	// 웹브라우저에 출력되는 값이 callback함수로 리턴된다.
	out.println(result); //매개변수인 data의 값으로 전해진다.
	
%>    