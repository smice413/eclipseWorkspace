<%@page import="board.BoardDataBean"%>
<%@page import="board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="board" class="board.BoardDataBean"/>
<jsp:setProperty property="*" name="board"/>

<%
	String nowpage = request.getParameter("page");
	//num값은 hidden으로 넘어와 자바빈 객체에 주소값으로 받을 수 있기 때문에 따로 안해도되지만, page는 객체 주소값에 선언 안되어 있기 때문에 따로 값을 받는다.

	BoardDBBean dao = BoardDBBean.getinstance();
	BoardDataBean old = dao.getContent(board.getNum());
	
	// 비번 비교
	if(old.getPasswd().equals(board.getPasswd())){	//비번 일치시
		int result = dao.update(board); //update SQL문 실행. 1을 받음
		
		if(result == 1){
%>
			<script>
				alert("글수정 성공");
				<%-- location.href="list.jsp?page=<%=nowpage%>"; --%>
				location.href="content.jsp?num=<%=board.getNum()%>&page=<%=nowpage%>";
			</script>		
		
					
<%}	
	}else{ // 비번 불일치시 %>
		<script>
			alert("비번이 일치하지 않습니다.");
			history.go(-1);
		</script>
<% } %>