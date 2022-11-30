<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String dan = request.getParameter("num");
 	int a = Integer.parseInt(dan);
	
		out.println("구구단"+a+"단"+"<br>");	
	for(int i=1; i<=9; i++){
		out.println(a + "*" + i+ "=" + a * i+"<br>");
	}
%>