<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.sql.Timestamp"%>

<%
	// 날짜, 시간 클래스
	// 1. Date 클래스
	
//	java.util.Date d = new java.util.Date();
	Date d = new Date();

	SimpleDateFormat sd =
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE요일");
	
	// 2. Timestamp 클래스
	Timestamp ts = new Timestamp(System.currentTimeMillis());
	
%>

현재시간1 : <%=d %> <br> 				<!-- 현재시간1 : Mon Feb 28 15:20:07 KST 2022  -->
현재시간2 : <%=sd.format(d) %> <br>	<!-- 현재시간2 : 2022-02-28 15:20:07 월요일  -->
현재시간3 : <%=ts %> <br>				<!-- 현재시간3 : 2022-02-28 15:20:07.612  -->
현재시간4 : <%=sd.format(ts) %> <br>	<!-- 현재시간4 : 2022-02-28 15:20:07 월요일  -->
    