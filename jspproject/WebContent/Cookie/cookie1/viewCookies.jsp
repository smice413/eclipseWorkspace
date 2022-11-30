<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ page import = "java.net.URLDecoder" %>

<html>
	<head><title>쿠키목록</title></head>
	<body>
	쿠키 목록<br>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null && cookies.length > 0) {
        for (int i = 0 ; i < cookies.length ; i++) {
%>

			<!-- 쿠키값을 URLEncoder 클래스를 이용해서 디코딩 한다. -->
			<%= cookies[i].getName() %> = 
			<%= URLDecoder.decode(cookies[i].getValue()) %><br> <!-- URLDecoder.decode(): 한글값 최범균이 안깨지고 출력된다. -->

<%
        }//for end

    } else {
%>

		쿠키가 존재하지 않습니다.
<%
    }
%>

	</body>
</html>