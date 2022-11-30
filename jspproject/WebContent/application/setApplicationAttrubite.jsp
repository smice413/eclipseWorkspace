<%@ page contentType = "text/html; charset=euc-kr" %>
<%
//    String name = request.getParameter("name");
//    String value = request.getParameter("value");
  
	String name = "test";
	String value = "1234";


    if (name != null && value != null) {
        application.setAttribute(name, value); // 공유 설정
//      application.setAttribute("test", "1234"); // 공유 설정
    }
%>

<html>
<head><title>application 속성 지정</title></head>
<body>
<%
    if (name != null && value != null) {
%>
application 기본 객체의 속성 설정:
 <%= name %>  = <%= value %>
<%
    } else {
%>
application 기본 객체의 속성 설정 안함
<%
    }
%>
</body>
</html>