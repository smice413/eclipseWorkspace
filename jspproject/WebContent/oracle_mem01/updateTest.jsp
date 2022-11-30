<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="java.sql.*"%>

<%
  request.setCharacterEncoding("euc-kr");

  String id= request.getParameter("id");
  String passwd= request.getParameter("passwd");
  String name= request.getParameter("name");

  Connection conn=null;
  PreparedStatement pstmt=null;
  ResultSet rs=null;

  try{
	String jdbcUrl="jdbc:oracle:thin:@localhost:1521:xe";
    String dbId="scott";
    String dbPass="tiger";
	 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn=DriverManager.getConnection(jdbcUrl,dbId ,dbPass );
	
	String sql= "select id, passwd from member1 where id= ?"; //히든타입의 id값과 비번을 받는 SQL문
	pstmt=conn.prepareStatement(sql);
    pstmt.setString(1,id);
	rs=pstmt.executeQuery();
    
	if(rs.next()){ // id가 있으면
		String rId=rs.getString("id");
		String rPasswd=rs.getString("passwd");
      if(id.equals(rId) && passwd.equals(rPasswd)){	//비번 일치시
	    sql= "update member1 set name= ?, reg_date=sysdate  where id= ? "; //아이디와 비번이 일치했기 때문에 name값 변경,수정한 날짜로 변경 SQL문
	    pstmt=conn.prepareStatement(sql);
	    pstmt.setString(1,name); //SQL문에서 물음표가 2개 중에 첫번째물음 표에 수정한 이름을 name변수에 저장
	    pstmt.setString(2,id);
	    pstmt.executeUpdate();
	   
%>
		<script>
			alert("회원 정보 수정 성공");
			location.href="selectTest.jsp";
		</script>	
<%
       }else{ //비번 불일치시
 %>
	 <script>
	 	alert("비밀번호가 틀렸습니다");
	 	history.go(-1);
	 </script>
	 	
<% 	 
		}
	 }else{
%>
		<script>
			alert("아이디가 틀렸습니다.");
			history.go(-1);
		</script>
<%
	 }

	}catch(Exception e){ 
		e.printStackTrace();
	}finally{
		if(rs != null) try{rs.close();}catch(SQLException sqle){}
		if(pstmt != null) try{pstmt.close();}catch(SQLException sqle){}
		if(conn != null) try{conn.close();}catch(SQLException sqle){}
	}
%>