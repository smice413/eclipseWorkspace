<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="java.util.*" %>

<html>
	<head><title>���� ��� ����</title></head>
	<body>

<%--	// ������ : "id", "passwd"
	Enumeration attr = session.getAttributeNames(); //session�� �Ӽ����� �𸦶����

	while(	attr.hasMoreElements()	){ //������ ���� ������ true
		String attrName = (String)attr.nextElement(); //object������ ������
		String attrValue = (String)session.getAttribute(attrName);//�ٿ�ĳ����
		out.println("������ �Ӽ����� " + attrName + " �̰� ");
		out.println("������ �Ӽ����� " + attrValue + "�̴�.<br><br>");
	}
--%>

<%
	String id = (String)session.getAttribute("id");
	String passwd = (String)session.getAttribute("passwd");
%>

ID : <%=id %> <br>
��й�ȣ : <%=passwd %> <br>

	</body>
</html>
