<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>selProduct.jsp</title>
</head>
<%
	// HTML FORM ���� ���޵� �������� �ѱ����ڵ�
	request.setCharacterEncoding("euc-kr");
	
	// session �� username �̸����� HTML FORM �� <input type="text" name="username"/> �� �Էµ� ���� ������. 
	session.setAttribute("username",request.getParameter("username"));
%>
<body>
<center>
	<H2>��ǰ����</H2>
	<HR>
	<%=session.getAttribute("username") %>���� �α��� �� ���� �Դϴ�.

	${username} <%-- EL(ǥ���� ���)����ϴ� ��� : ${} --%>
	<HR>
	<form name="form1" method="POST" action="add.jsp">
		<SELECT name="product">
			<option>���</option> <%--option �±׿� value���� ���� �ʾƵ� text�� �ڵ����� value������ ���޵� --%>
			<option>��</option>
			<option>���ξ���</option>
			<option>�ڸ�</option>
			<option>����</option>
		</SELECT>
		<input type="submit" value="�߰�"/>
	</form>
	<a href="checkOut.jsp">���</a>
</center>
</body>
</html>