<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
회원가입폼
</header>

<form method="get" action="memberinsert.jsp">
<table border="1">
<caption>회원가입</caption>
<tr>
<td>아이디</td>
<td><input type="text" id="id" name="id"></td>
</tr>
<tr>
<td>비밀번호</td>
<td><input type="password" id="password" name="password"></td>
</tr>
<tr>
<td>성명</td>
<td><input type="text" id="name" name="name"></td>
</tr>
<tr>
<td>성별</td>
<td>
남자<input type="radio" id="men" name="gender" value="m">
여자<input type="radio" id="women" name="gender" value="w">
</td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="회원가입">
</td>
</tr>

</table>
</form>










<footer>
in 엔제리너스
</footer>

</body>
</html>