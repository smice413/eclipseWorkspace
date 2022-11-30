<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
<title>JSTL sql 라이브러리 사용 예제</title>
</head>
<body>

<sql:setDataSource var="conn" driver="oracle.jdbc.driver.OracleDriver" 
				url="jdbc:oracle:thin:@localhost:1521:xe"
				user="scott" 
				password="tiger"/>

<!-- insert sql문을 한번만 실행해라. 왜냐하면 num이 primary key이기 때문에 num값이 중복되어 오류 발생함 -->
<sql:update dataSource="${conn}">
	INSERT INTO test (num, name) VALUES (1, '홍길동')
</sql:update>
<sql:update dataSource="${conn}">
	INSERT INTO test (num, name) VALUES (2, '조준동')
</sql:update>
<sql:update dataSource="${conn}">
	INSERT INTO test (num, name) VALUES (3, '홍길동')
</sql:update>
<sql:update dataSource="${conn}">
	INSERT INTO test (num, name) VALUES (4, '홍길순')
</sql:update>

<sql:query var="rs" dataSource="${conn}">
	SELECT * FROM test WHERE name=?
	<sql:param>홍길동</sql:param> <!-- ?에 할당할 값을 홍길동으로 하라는 의미 -->
</sql:query>

<c:forEach var="data" items="${rs.rows}">
	<c:out value="${data['num']}"/>
	<c:out value="${data['name']}"/>
	<br>
</c:forEach>

</body>
</html>
