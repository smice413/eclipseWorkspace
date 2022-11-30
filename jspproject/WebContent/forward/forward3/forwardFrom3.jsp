<%@ page contentType="text/html;charset=euc-kr"%>

<html>
	<body>

	<h2>포워딩하는 페이지: forwardTagFrom2.jsp</h2> <%-- 화면에 출력은 안되어도 코드자체의 실행은 되는 것  --%>

<%
   request.setCharacterEncoding("euc-kr");

   String name = request.getParameter("name");
   String selectedColor = request.getParameter("color");
%>

<%-- 제일 바깥쪽에 반드시 쌍따옴표가 있어야 한다. 쌍따옴표안에 쌍따옴표를 못 붙이지만 \"를 하면 괜찮다. 자바 기반이기 때문에 외따옴표 안된다.--%>
<jsp:forward page="<%=selectedColor+\".jsp\"%>"> 
    <jsp:param name="selectedColor" value="<%=selectedColor%>"/>
	<jsp:param name="name" value="<%=\"신성호\"%>"/> 
</jsp:forward>
	<%-- 입력란에 홍길동을 입력했지만 신성호를 값으로 받았다.우선순위가 jsp:param이다. --%>