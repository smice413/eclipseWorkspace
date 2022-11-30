<%@ page contentType = "text/html; charset=utf-8" %>
<%@ page buffer="1kb" %> <%-- 기본은 8kbyte이다. --%>
<%@ page errorPage = "/error/viewErrorMessage.jsp" %>
<html>
<head><title>버퍼 플러시 이후 에러 발생 결과</title></head>
<body>

<%  for (int i = 0 ; i < 300 ; i++) { out.println(i); }  %>

<%= 1 / 0 %>

</body>
</html>
