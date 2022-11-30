<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(document).ready(function(){
		$("#close1").click(function(){			// 중복 ID버튼 클릭
			opener.$("#id").val("").focus(); // opener는 팝업창인 이곳에 소스를 작성했지만 부모창을 제어할 수 있는 함수임.즉, 부모창의 id작성하는 곳을 지우고 포커스를 설정하라는 의미
			window.close();//팝업창 닫기
		});
		$("#close2").click(function(){			// 사용 가능한 ID버튼 클릭
			opener.$("#passwd").focus();
			window.close();
		});
		
	});

</script>
    
<%
	String id = request.getParameter("id");
	
	MemberDAO dao = MemberDAO.getInstance();
	
	// ID 중복검사 메소드 호출
	int result = dao.memberAuth(id);
	
	if(result == 1) {	// 중복 ID : 1
%>    
		<%=id%>는 중복 ID 입니다.<br><br><br>
		
		<input type="button" value="닫기" id="close1">
		
	<%}else{			// 사용 가능한 ID : -1%>		
		
		<%=id%>사용 가능한 ID 입니다. <br><br><br>
		
		<input type="button" value="닫기" id="close2">
		
		
	<%}%>