<%@ page contentType = "text/html; charset=euc-kr" %>

<%! //�����±�
	/**
	 * a�� b�� ���� �����Ѵ�.
	 */
	public int add(int a, int b) {
		return a + b;
	}
%>

<html>
<head><title>�ڹ� �ּ�</title></head>

<body>

<% //��ũ��Ʋ�� �±�
	int val1 = 10; // val1�� 10�� �Ҵ�
	int val2 = 20; // val2�� 20�� �Ҵ�
	
	/* va1�� va2�� ���� ���� �����
	   result�� �Ҵ��Ѵ�. */
	int result = add(val1, val2);
%>

<!-- ǥ���� �±� -->
<%= val1 %> + <%= val2 %> = <%= result /* �����? */ %>
<!-- ǥ���� �±� �ȿ� ������ �ּ��� �����ϴ�. -->

</body>
</html>