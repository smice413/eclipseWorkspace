<%@ page contentType="text/html; charset=euc-kr" %>
<% request.setCharacterEncoding("euc-kr");%>
<%@page import="javaBean.SimpleBean"%>


<%
	SimpleBean sb1 = new SimpleBean();
//	sb1.msg = "hi" // �ʵ�ɹ��� private�̱� ������ �������� X
	sb1.setMsg("�ȳ�");
%> <%-- jsp�ڵ�� �ϸ� ��ü ������ import�� ���� �ؾ��Ѵ�. --%>

<%-- useBean �׼� �±׸� ���� ��ü ������ import�� ���� ���ص� �ȴ�.���������� �˾Ƽ� ��. --%>
<jsp:useBean id="sb" class="javaBean.SimpleBean" />
<jsp:setProperty property="*" name="sb"/>
<%-- property���� *�� �ϸ� ��� property�� �ޱ� ������ ���� ���� �ۼ��� �ʿ����. --%>

<%-- <jsp:setProperty name="sb" property="msg" />
<jsp:setProperty name="sb" property="name"/> --%>
<%-- name�� ���� usebean�� id���� ���ƾ��Ѵ�. ��ü��(�ּҰ�)�� ����. --%>

<html>
	<body>

	<h1>������ �ڹٺ� ���α׷���</h1>
	<br>
	�̸� : <%=sb.getName() %> <br>
	�̸� : <jsp:getProperty name="sb" property="name"/><br>
	�޼��� : <%=sb.getMsg() %> <br>
	�޽��� : <jsp:getProperty name="sb" property="msg" />
	
	</body>
</html>