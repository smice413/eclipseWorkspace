<%@ page contentType="text/html; charset=euc-kr" %>
<% request.setCharacterEncoding("euc-kr");%>
<%@page import="javaBean.SimpleBean"%>


<%
	SimpleBean sb1 = new SimpleBean();
//	sb1.msg = "hi" // 필드맴버가 private이기 때문에 직접접근 X
	sb1.setMsg("안녕");
%> <%-- jsp코드로 하면 객체 생성시 import를 따로 해야한다. --%>

<%-- useBean 액션 태그를 쓰면 객체 생성시 import를 따로 안해도 된다.내부적으로 알아서 됨. --%>
<jsp:useBean id="sb" class="javaBean.SimpleBean" />
<jsp:setProperty property="*" name="sb"/>
<%-- property값을 *로 하면 모든 property를 받기 때문에 굳이 따로 작성할 필요없다. --%>

<%-- <jsp:setProperty name="sb" property="msg" />
<jsp:setProperty name="sb" property="name"/> --%>
<%-- name의 값은 usebean의 id값과 같아야한다. 객체명(주소값)과 같다. --%>

<html>
	<body>

	<h1>간단한 자바빈 프로그래밍</h1>
	<br>
	이름 : <%=sb.getName() %> <br>
	이름 : <jsp:getProperty name="sb" property="name"/><br>
	메세지 : <%=sb.getMsg() %> <br>
	메시지 : <jsp:getProperty name="sb" property="msg" />
	
	</body>
</html>