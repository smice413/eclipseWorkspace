<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="testboard.BoardDTO" %>
<%@ page import="testboard.BoardDAO" %>
<%@page import="java.util.*" %>

<%
	request.setCharacterEncoding("utf-8");

	String sel = request.getParameter("sel");
	String find = request.getParameter("find");
	

	// 1. 한 화면에 출력할 데이터 갯수
	int pageSize = 10;

	String pageNum = request.getParameter("pageNum");
	if(pageNum == null){
		pageNum = "1";
	}
	
	//2. 현재 페이지 번호
	int currentPage = Integer.parseInt(pageNum);
	int startRow = (currentPage-1) * pageSize + 1;
	int endRow = currentPage * pageSize;
			
	//3. 총 데이터 갯수 
	int count = 0;
	int fcount = 0;
	int number=0;    // 화면에 출력되는 번호
	int fnumber=0;    // 화면에 출력되는 번호
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br>
<a href="boardForm.jsp">글작성</a>
<table border=1 align=center width=500>
	<tr><td>번호</td>
			<td>작성자</td>
			<td>제목</td>
	</tr>
	
<%
	List list = null;
	List flist = null;
	BoardDAO  manager = BoardDAO.getInstance();

	count = manager.getCount();
	fcount = manager.getFcount(sel, find);
	System.out.println("count="+count);
	System.out.println("fcount="+fcount);
	out.println("<br>");
	out.println("count="+count+"<br>");
	out.println("fcount="+fcount+"<br>");	
	out.println("sel="+sel+"<br>");	
	out.println("find="+find+"<br>");	
	
	number = count - (currentPage-1) * pageSize;
	fnumber = fcount - (currentPage-1) * pageSize;
	
	if(count > 0){
		list = manager.selectBoard(startRow, endRow);
	}
	if(fcount > 0){
		flist = manager.selectFboard(startRow, endRow, sel, find);
	}
	System.out.println("list="+list);
	System.out.println("flist="+flist);
	
	
//  전체 목록
if(count>0 && fcount==0){	
	for(int i=0; i<list.size(); i++){
		BoardDTO board = (BoardDTO)list.get(i);	
%>	
	
	<tr><td><%=number-- %></td>
			<td><%=board.getWriter() %></td>
			<td>
				<a href="content.jsp?no=<%=board.getNo()%>&pageNum=<%=currentPage%>">
					<%=board.getSubject() %>
				</a>
			</td>
	</tr>
	
<%} // for end
	
	
// 검색 목록	
}else if(count>0 && fcount != 0){
	for(int i=0; i<flist.size(); i++){
		BoardDTO board = (BoardDTO)flist.get(i);	
%>	
	
	<tr><td><%=fnumber-- %></td>
			<td><%=board.getWriter() %></td>
			<td>
				<a href="content.jsp?no=<%=board.getNo()%>&pageNum=<%=currentPage%>">
					<%=board.getSubject() %>
				</a>
			</td>
	</tr>
	
<%} // for end
	
}	
%>	

</table>



<!-- 페이지 출력 -->
<center>
<%
	// 전체 목록 페이지 처리
	if(count>0 && fcount == 0){
		
		// 총 페이지수
		int pageCount = count / pageSize + ((count%pageSize == 0)? 0 : 1);
		
		// 각 블럭의 시작페이지 번호
		int startPage = ((currentPage-1)/10) * pageSize +1;
		
		// 각 블럭의 끝페이지 번호
		int endPage = startPage +10 - 1;		

		// 존재하는 페이지만 출력
		if(endPage > pageCount) endPage = pageCount;
		
		
		// 이전 블럭으로 이동
		if(startPage > 10){
%>			
			<a href="boardlist.jsp?pageNum=<%=startPage-10%>"><%="[이전]"%></a>
<%	}else{  %>
			<%="[이전]"%>				
<%	}
		
		
		// 각 블럭에 10개의 페이지 출력 
		for(int i=startPage; i<=endPage; i++ ){
			if(i==currentPage){		// 현재 페이지
%>
				<%=i %>
			
<% 		}else{  %>
				<a href="boardlist.jsp?pageNum=<%=i%>"><%=i %></a>	
<%		}
		} 
		
		
		// 다음 블럭으로 이동
		if(endPage < pageCount){
%>		
			<a href="boardlist.jsp?pageNum=<%=startPage+10%>"><%="[다음]"%></a>
<%	}else{  %>
			<%="[다음]"%>	
<%	}

		
// 검색 목록 페이지 처리		
	}else if(fcount > 0){
		// 총 페이지수
				int pageCount = fcount / pageSize + ((fcount%pageSize == 0)? 0 : 1);
				
				// 각 블럭의 시작페이지 번호
				int startPage = ((currentPage-1)/10) * pageSize +1;
				
				// 각 블럭의 끝페이지 번호
				int endPage = startPage +10 - 1;		

				// 존재하는 페이지만 출력
				if(endPage > pageCount) endPage = pageCount;
				
				
				// 이전 블럭으로 이동
				if(startPage > 10){
		%>			
					<a href="boardlist.jsp?pageNum=<%=startPage-10%>&sel=<%=sel%>&find=<%=find%>"><%="[이전]"%></a>
		<%	}else{  %>
					<%="[이전]"%>				
		<%	}
				
				
				// 각 블럭에 10개의 페이지 출력 
				for(int i=startPage; i<=endPage; i++ ){
					if(i==currentPage){		// 현재 페이지
		%>
						<%=i %>
					
		<% 		}else{  %>
						<a href="boardlist.jsp?pageNum=<%=i%>&sel=<%=sel%>&find=<%=find%>"><%=i %></a>	
		<%		}
				} 
				
				
				// 다음 블럭으로 이동
				if(endPage < pageCount){
		%>		
					<a href="boardlist.jsp?pageNum=<%=startPage+10%>&sel=<%=sel%>&find=<%=find%>"><%="[다음]"%></a>
		<%	}else{  %>
					<%="[다음]"%>	
		<%	}
		
	}

%>
<br><br><br>


<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(document).ready(function(){
		$("form").submit(function(){
			if($("select").val()==""){
				alert("검색할 항목을 선택");
				return false;
			}
			if($("#find").val()==""){
				alert("검색어를 입력하세요");
				$("#find").focus();
				return false;
			}				
		});
	});
</script>

<form method=post action="boardlist.jsp">
	<select name="sel">
		<option value="">검색</option>
		<option value="writer">작성자</option>
		<option value="subject">제목</option>
		<option value="content">내용</option>
	</select>
	<input type=text name="find" id="find">
	<input type=submit value="검색">
</form>

</center>
</body>
</html>