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
	
	if(old.getPasswd().equals(regBean.getPasswd())){	// 비번 일치시 실행// regBean.getPasswd(): 사용자가 직접 입력한 비번 //old는 이전에 저장된 비번 
		manager.update(regBean); //update SQL문 실행, 수정된 데이터 갱신 ,regBean은 클래스형태의 자료형으로 update메소드에 매개변수로 선언해놨기 때문에 넣을 수있다.
		
%>	
	<script>
		alert("회원수정 성공");
		location.href="list.jsp";
	</script>
	
<% }else{%>

	<script>
		alert("비밀번호가 일치하지 않습니다.");
		history.go(-1);
	</script>

<% } %>



