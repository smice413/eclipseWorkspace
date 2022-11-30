<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<a href="./BoardForm.do">글작성</a> <br>
글갯수 : ${listcount} 개 <br>

<%
//	 int count = (int) request.getAttribute("listcount");
	 int count = ((Integer) request.getAttribute("listcount")).intValue();
%>
글갯수 : <%=count%> 개 <br>

<table border=1 width=700 align="center">
	<caption>게시판 목록</caption>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
	
	<c:set var="num" value="${listcount - (page-1) * 10}"/> <!-- *10은 limit값이다. 단지 공유하지 않았기 때문에 10을 넣은것 -->
	<c:forEach var="b" items="${boardlist}">
	<tr>
		<td>${num} <!-- num을 먼저 출력하고 밑에 1감소시킨 num값이 EL에 num에 위로 루프돌아서 다시 저장되어 출력된다.이것이 반복되어 1감소되는 값들이 출력된다. -->
			<c:set var="num" value="${num-1}"/>
		</td>	
		<td>
			<!-- 댓글 제목 앞에 여백 처리 -->
			<c:if test="${b.board_re_lev > 0}"> <!-- ${b.board_re_lev > 0} = 댓글이라는 의미. 원문은 0이기 때문 -->
				<c:forEach var ="i" begin="0" end="${b.board_re_lev}"> <!-- 댓글 깊이 숫자 만큼 루프가 돌아 여백이 생긴다. -->
					&nbsp;
				</c:forEach>
			</c:if>
		
<a href="./BoardDetailAction.do?board_num=${b.board_num}&page=${page}">	
			${b.board_subject}
		</a>		
			
		</td>
		<td>${b.board_name}</td>
		<td>
		<fmt:formatDate value="${b.board_date}"
						pattern="yyyy-MM-dd a hh:mm:ss EEE 요일"/>
		</td>
		<td>${b.board_readcount}</td>
		</tr>
	</c:forEach>
	
	
</table> <br><br>

<!-- 페이지 처리 -->
<center>
<c:if test="${listcount > 0}"> <!-- 데이터가 있으면 출력하겠다는 의미 -->

<!-- 1페이지로 이동 -->
<a href="./BoardListAction.do?page=1" style="text-decoration:none"> << </a>

<!-- 이전 블럭으로 이동 -->
<c:if test="${startPage > 10 }">
	<a href="./BoardListAction.do?page=${startPage-1}">[이전]</a>
</c:if>

<!-- 각 블럭에 10개의 페이지 출력 -->
<c:forEach var="i" begin="${startPage}" end="${endPage}">
	<c:if test="${i == page}"> <!-- 현재 페이지 -->
		[${i}]
	</c:if>
	<c:if test="${i != page}"> <!-- 현재 페이지가 아닌 경우 -->
		<a href="./BoardListAction.do?page=${i}">[${i}]</a>
	</c:if>
</c:forEach>
	<c:if test="${endPage < pageCount }">
		<a href = "./BoardListAction.do?page=${startPage+10}">[다음]</a>	
	</c:if>

<!-- 마지막 페이지로 이동 -->
<a href="./BoardListAction.do?page=${pageCount}"
	style="text-decoration:none"> >> </a>
	
</c:if>
</center>






		
