<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String password = request.getParameter("password");
String name = request.getParameter("name");
String gender = request.getParameter("gender");

Connection conn = null;
PreparedStatement pstmt= null;
int result = 0;

try{
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String jdbcid = "scott";
	String passwd = "tiger";
	
	//jdbc 연결
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn=DriverManager.getConnection(url, jdbcid, passwd);
	
	//sql문 작성
	String sql = "insert into membership values(?,?,?,?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id );
	pstmt.setString(2, password);
	pstmt.setString(3, name);
	pstmt.setString(4, gender);
	
	result = pstmt.executeUpdate(); //sql 실행 // 실행 성공시 1을 리턴받음
	
}catch(Exception e){
	e.printStackTrace();
}finally{
	if(pstmt != null )try{pstmt.close();}catch(Exception e){}finally{}
	if(conn != null)try{conn.close();}catch(Exception e){}finally{}
}



%>


<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% if(result == 1){ %>
<script>
alert("회원가입성공");
location.href="memberdetail.jsp";
</script>
<% }else{ %>
<script>
alert("회원가입실패");
location.href="memberform.jsp";
</script>

<%} %>
</body>
</html>