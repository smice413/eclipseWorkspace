<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ page import = "java.net.URLEncoder" %>

<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0) {
        for (int i = 0 ; i < cookies.length ; i++) {

            if (cookies[i].getName().equals("name")) {
                Cookie cookie = new Cookie("name", ""); //쿠키 값을 null값으로 만듬
                cookie.setMaxAge(0); //쿠키가 발행되면 바로 지워게함
                response.addCookie(cookie);
            }//if end

        }//for end
    }
%>

<html>
	<head><title>쿠키 삭제</title></head>
	<body>
		name 쿠키를 삭제합니다.
	</body>
</html>
