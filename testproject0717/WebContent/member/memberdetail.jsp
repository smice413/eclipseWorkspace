<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
<%
request.setCharacterEncoding("utf-8");



Connection conn = null;
PreparedStatement pstmt= null;
ResultSet rs = null;


try{
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String jdbcid = "scott";
	String passwd = "tiger";
	
	//jdbc 연결
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn=DriverManager.getConnection(url, jdbcid, passwd);
	
	//sql문 작성
	String sql = "select * from membership ";
	pstmt = conn.prepareStatement(sql);
	
	rs = pstmt.executeQuery();//sql 실행 단, select문 만 해당됨.
	
	while(rs.next()){
		String id = rs.getString("id");
		String password = rs.getString("password");
		String name = rs.getString("name");
		String gender= rs.getString("gender");
	%>	
		<table border="1">
		<br><br>
		<tr>
		<td>아이디</td>
		<td><%=id%></td>
		</tr>
		<tr>
		<td>비밀번호</td>
		<td><%=password%></td>
		</tr>
		<tr>
		<td>성명</td>
		<td><%=name %></td>
		</tr>
		<tr>
		<td>성별</td>
		<td>
		<%=gender %>
		</td>
		</tr>
		<tr>
		<td colspan="2">

		</td>
		</tr>

		</table>
<%		
		
	}
	
}catch(Exception e){
	e.printStackTrace();
}finally{
	if(pstmt != null )try{pstmt.close();}catch(Exception e){}finally{}
	if(conn != null)try{conn.close();}catch(Exception e){}finally{}
	if(rs != null)try{rs.close();}catch(Exception e){}finally{}
}



%>













<footer>
in 엔제리너스
</footer>

</body>
</html>