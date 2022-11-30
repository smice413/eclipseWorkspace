<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- request.getParameter("id") 관리자가 id라는 변수로 받은 값을 request로 전달 받는 것이다.
     request.getParameter("passwd")
로그인할 때 입력한 아이디와 비밀번호 값을 받아 출력 받을 수 있다. -->    
ID : <%=request.getParameter("id") %> <br>
비밀번호 : <%=request.getParameter("passwd") %>