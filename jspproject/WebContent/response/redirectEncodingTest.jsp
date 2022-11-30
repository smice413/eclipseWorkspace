<%@ page contentType = "text/html; charset=utf-8" %>
<%@ page import = "java.net.URLEncoder" %>
<%
    String value = "자바";
    String encodedValue = URLEncoder.encode(value); 
    response.sendRedirect("first.jsp?name=" + encodedValue);
//  response.sendRedirect("first.jsp?name=" + value);
%>