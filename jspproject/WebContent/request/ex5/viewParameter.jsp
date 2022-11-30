<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>

<%
    request.setCharacterEncoding("utf-8");
%>

<html>
<head><title>요청 파라미터 출력</title></head>
<body>

<b>request.getParameter() 메소드 사용</b><br>
name 파라미터 = <%= request.getParameter("name") %> <br>
address 파라미터 = <%= request.getParameter("address") %>
<p>

<b>request.getParameterValues() 메소드 사용</b><br>
<%
    String[] values = request.getParameterValues("pet");
    if (values != null) {
    	for (int i = 0 ; i < values.length ; i++) {
%>
			<%= values[i] %>
<%
  		}
  	}
%>
<p>

<b>request.getParameterNames() 메소드 사용</b><br>
<%	//열거형 : Enumeration num = "name", "address", "pet"
    Enumeration num = request.getParameterNames();
    while(num.hasMoreElements()) { //boolean형 값이 있으면 true
        String name = (String)num.nextElement();//다운캐스팅: object를 String으로
%>
        <%= name %>
<%
    }
%>
<p>

<b>request.getParameterMap() 메소드 사용</b><br>
<% //key(String형) value값(String[])으로 돌려줌
    Map parameterMap = request.getParameterMap();
    String[] nameParam = (String[])parameterMap.get("name");
    if (nameParam != null) {
%>
name = <%= nameParam[0] %>
<%
	}
%>

</body>
</html>