<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 환영합니다. <%=request.getParameter("username") %>님  <br><!-- "username"은 html파일의 key값이다.key값과 명칭이 같아야한다. -->
 환영합니다. ${param.username}님  <br>
</body>
</html>