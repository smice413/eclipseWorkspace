<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ page import = "java.net.URLEncoder" %>

<%  // ��Ű���� URLEncoder Ŭ������ �̿��ؼ� ���ڵ� �Ѵ�.
    Cookie cookie = new Cookie("name", URLEncoder.encode("�ֹ���")); //URLEncoder.encode(): �ѱ��� ������.���� decode�� �ؾ���
    response.addCookie(cookie);
%>

<html>
	<head><title>��Ű����</title></head>
	<body>

<%= cookie.getName() %> ��Ű�� �� = "<%= cookie.getValue() %>"
<!-- getName(): "name"�� ������ -->
	</body>
</html>