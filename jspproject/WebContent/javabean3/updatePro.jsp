<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="JavaBeanMember.register.LogonDataBean" %>
<%@ page import="JavaBeanMember.register.LogonDBBean" %>
<%@include file="color.jsp" %>

<% 
  request.setCharacterEncoding("euc-kr");

  LogonDataBean	regBean1 = new LogonDataBean();
// regBean1.id="test";
%>

<jsp:useBean id="regBean" class="JavaBeanMember.register.LogonDataBean" />
<jsp:setProperty name="regBean" property="*" />

<%
	LogonDBBean manager = LogonDBBean.getInstance();

	LogonDataBean old = manager.updateForm(regBean.getId());
	
	if(old.getPasswd().equals(regBean.getPasswd())){	// ��� ��ġ�� ����// regBean.getPasswd(): ����ڰ� ���� �Է��� ��� //old�� ������ ����� ��� 
		manager.update(regBean); //update SQL�� ����, ������ ������ ���� ,regBean�� Ŭ���������� �ڷ������� update�޼ҵ忡 �Ű������� �����س��� ������ ���� ���ִ�.
		
%>	
	<script>
		alert("ȸ������ ����");
		location.href="list.jsp";
	</script>
	
<% }else{%>

	<script>
		alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		history.go(-1);
	</script>

<% } %>



