<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.Enumeration"%>
<html>
<head>
<title>Attribute Test</title>
</head>
<body>
<h2>������ �Ӽ� �׽�Ʈ</h2>
<table border="1">
	<tr><td colspan="2">Application ������ ����� �����</td></tr>
	<tr>
		<td>�̸�</td>
		<td><%=application.getAttribute("name") %></td>
	</tr>
	<tr>
		<td>���̵�</td>
		<td><%=application.getAttribute("id") %></td>
	</tr>
</table>
<br>
<table border="1">
	<tr><td colspan="2">Session ������ ����� �����</td></tr>
<%-- <%
//�����Ǵ� ���� ���� ���� �� ���������� ó���Ѵ�.
Enumeration e=session.getAttributeNames(); //email, address, tel
while(e.hasMoreElements()){ //���� ������ true�� ���๮ ����
	String attributeName=(String)e.nextElement(); //������ ������� ���� �������ڴٴ� �ǹ�
	String attributeValue=(String)session.getAttribute(attributeName);
	%>
	<tr>
		<td><%=attributeName %></td>
		<td><%=attributeValue %></td>
	</tr>
	<%
}
%> --%>

<!-- �����Ǵ� ���� �˶� �̷��� ó����. -->
	<tr>
		<td>email</td>
		<td><%=session.getAttribute("email") %></td>
	</tr>
	<tr>
		<td>tel</td>
		<td><%=session.getAttribute("tel") %></td>
	</tr>
	<tr>
		<td>address</td>
		<td><%=session.getAttribute("address") %></td>
	</tr>
		

</table>
</body>
</html>
