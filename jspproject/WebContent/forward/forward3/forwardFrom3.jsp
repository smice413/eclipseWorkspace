<%@ page contentType="text/html;charset=euc-kr"%>

<html>
	<body>

	<h2>�������ϴ� ������: forwardTagFrom2.jsp</h2> <%-- ȭ�鿡 ����� �ȵǾ �ڵ���ü�� ������ �Ǵ� ��  --%>

<%
   request.setCharacterEncoding("euc-kr");

   String name = request.getParameter("name");
   String selectedColor = request.getParameter("color");
%>

<%-- ���� �ٱ��ʿ� �ݵ�� �ֵ���ǥ�� �־�� �Ѵ�. �ֵ���ǥ�ȿ� �ֵ���ǥ�� �� �������� \"�� �ϸ� ������. �ڹ� ����̱� ������ �ܵ���ǥ �ȵȴ�.--%>
<jsp:forward page="<%=selectedColor+\".jsp\"%>"> 
    <jsp:param name="selectedColor" value="<%=selectedColor%>"/>
	<jsp:param name="name" value="<%=\"�ż�ȣ\"%>"/> 
</jsp:forward>
	<%-- �Է¶��� ȫ�浿�� �Է������� �ż�ȣ�� ������ �޾Ҵ�.�켱������ jsp:param�̴�. --%>