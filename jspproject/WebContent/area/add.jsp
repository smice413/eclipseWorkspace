<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.ArrayList"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%	

	// HTML ������ �Էµ� �ѱ� ó���� ���� �κ�
	request.setCharacterEncoding("euc-kr");

	// product �Ӽ����� ���޵� �Ķ���͸� �о��.
	String productname = request.getParameter("product");

	// session scope �� ����� productlist ��� �̸��� ArrayList ��ü�� ������ ��.
	ArrayList list = (ArrayList)session.getAttribute("productlist"); //�ٿ�ĳ����: object�� ArraylistŬ������

	// ���� null �� ��� ó�� �����͸� �߰��� ���̹Ƿ� ���ο� ArrayList ����
	if(list == null) {
		list = new ArrayList();
	}

	// ArrayList �� ���ο� ������ �߰�
	list.add(productname);
	session.setAttribute("productlist",list); //���������ϰ� �����Ҵ��ϴ� ��ġ�� ������µ�?
%>

	<!-- �ڹٽ�ũ��Ʈ�� �̿��� ������ �޽��� ���  -->
	<script>
		alert("<%=productname %> ��(��)�߰� �Ǿ����ϴ�.!!");
		history.go(-1); //�ڹٽ�ũ��Ʈ�� history��ü (���� ���Ϸ� ���ư��� ��). go(-1): ���� ���Ϸ� ���ư�
	</script>
</body>
</html>