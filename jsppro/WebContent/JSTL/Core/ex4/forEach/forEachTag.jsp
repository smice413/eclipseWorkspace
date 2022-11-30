<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    java.util.HashMap mapData = new java.util.HashMap();
    mapData.put("name", "최범균");
    mapData.put("today", new java.util.Date());
%>
<c:set var="intArray" value="<%= new int[] {1,2,3,4,5} %>" />
<c:set var="map" value="<%= mapData %>" />
<html>
<head><title>forEach 태그</title></head>
<body>
<h4>1부터 100까지 홀수의 합</h4>
<c:set var="sum" value="0" /> <!-- sum 초기값 0 -->
<c:forEach var="i" begin="1" end="100" step="2"> <!-- i값이 1부터 100까지 적용됨. step="2" : i가 2씩 증가 -->
<c:set var="sum" value="${sum + i}" /> <!-- 0+1, 1+3, 4+5... -->
</c:forEach>
결과 = ${sum}

<h4>구구단: 4단</h4>
<ul>
<c:forEach var="i" begin="1" end="9">
   <li>4 * ${i} = ${4 * i}
</c:forEach>
</ul>

<h4>int형 배열</h4>

<c:forEach var="i" items="${intArray}" begin="2" end="4"> <!-- items값은 배열, list자료 구조가 들어가는데 request객체로 공유하는 name값 또는 set으로 정의된 변수명이 들어감
														배열방 2번~4번까지 값 구해옴 -->
    [${i}]
</c:forEach>

<h4>Map</h4>

<c:forEach var="i" items="${map}">
    ${i.key} = ${i.value}<br>
</c:forEach>
<br><br>

<%
	List list = new ArrayList();
	list.add("자바");
	list.add("웹표준");
	list.add("JSP");
	list.add("오라클");
	list.add("스프링");
	list.add("파이썬");
	list.add("텐서플로우");
	
	request.setAttribute("slist", list); //공유설정
%>

<!-- 방법1. 공유한 name으로 하는 법(가장 많이 씀)-->
<c:forEach var="s" items="${slist}">
	${s }<br>
</c:forEach>
<br><br>

<%
	List li = (List) request.getAttribute("slist");
	for(int i=0; i<li.size(); i++){
		String str = (String) li.get(i);
		out.println(str+"<br>");
	}
%>
<br><br>

<!-- 방법2. set으로 정의된 변수명으로 하는 법 -->
<c:set var="s1" value="<%=list %>"/>
<c:forEach var="s2" items="${s1}">
	${s2} <br>
</c:forEach>




</body>
</html>
