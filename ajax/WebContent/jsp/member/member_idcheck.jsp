<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dao.*" %>
<%
 request.setCharacterEncoding("UTF-8");
 
 String id=request.getParameter("memid"); 
 System.out.println("id="+id);// id="test";
 
 MemberDAOImpl md=new MemberDAOImpl();

 int re=md.checkMemberId(id);
 //re=1이면 중복 -1이면 사용가능 아이디

// 웹브라우저에 출력되는 값이 callback함수로 리턴된다.		//꼭 출력되는 값만 콜백함수로 리턴될 수 있나???? 답: 반드시 출력되는 값만 가능하다. 이외의 것은 스프링에서 가능
// out.println(re); out은 출력시킬 수 있는 내장 객체이다.
%>
 
<%=re%>