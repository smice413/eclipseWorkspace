<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.BoardDataBean"%>
<%@page import="java.util.List"%>
<%@page import="board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>

<%
	// 1. 한 화면에 출력할 데이터 갯수(기본변수 1)
	int page_size = 10; //한 화면(페이지)에 10개씩 데이터 출력
	
	String pageNum = request.getParameter("page"); //get방식으로 받음
	if(pageNum == null){	// location객체로 list.jsp를 실행하는데 page값이 전달되지 않을 때 null값이 되기 때문에 1페이지로 지정한것 .또한 int형으로 변환해야하는데 null값은 변환안됨.
		pageNum = "1";		// 1 page : 최근글이 보이는 페이지
	}
	
	// 2. 현재 페이지 번호(기본변수 2)
	int currentPage = Integer.parseInt(pageNum);
	
	// 위의 기본변수 2개에 의해 파생된 변수 2개 startRow endRow
	// startRow : 각 page에 출력할 데이터의 시작 번호
	// endRow : 각 page에 출력할 데이터의 끝 번호
	// page = 1 : startRow=1, endRow=10
	// page = 2 : startRow=11, endRow=20
	// page = 3 : startRow=21, endRow=30
	
	int startRow = (currentPage -1) * page_size +1;
	int endRow = currentPage * page_size;
	
	// 3. 총 데이터 갯수(기본변수3)
	int count = 0;
	
	BoardDBBean dao = BoardDBBean.getinstance();
	count = dao.getCount();
	System.out.println("count:"+count); //콘솔창: count:130
	
	List<BoardDataBean> list = null;
	if(count>0){
		list = dao.getList(startRow, endRow); // 게시판 목록
	}
	System.out.println("list:"+list); //DTO객체의 주소값이 저장되어 있음
	
	if(count == 0){
%>
		작성된 글이 없습니다.
<% 	}else{ %>
		<a href="writeForm.jsp">글작성</a> 글갯수 : <%=count %>
		<table border=1 width=700 align=center>
			<caption>게시판 목록</caption>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>IP주소</th>
			</tr>
<%
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


			// number : 각 페이지에 출력될 시작 번호 //primary key인 num은 안됨. 데이터가 삭제되었을 경우 num가 연속으로 안나타남
			int number = count - (currentPage-1) * page_size;
// 1page = number = 130-(1-1)*10= 130
			for(int i=0; i<list.size(); i++){
				BoardDataBean board = list.get(i); //제네릭을 쓰기 때문에 앞에 BoardDataBean 생략 가능
%>			
			<tr>
				<td><%=number-- %></td>
				<td>
				<a href="content.jsp?num=<%=board.getNum()%>&page=<%=currentPage%>"><!-- 제목을 클릭해서 들어갔다가 나오면 제목을 클릭했던 현재페이지로 돌아옴 -->
				<%=board.getSubject() %>
				</a>
				</td>
				<td><%=board.getWriter() %></td>
				<td><%=sd.format(board.getReg_date()) %></td>
				<td><%=board.getReadcount() %></td>
				<td><%=board.getIp() %></td>
			</tr>	
<% 			} // for end%>
			
		</table>
<%} %>

<!-- 페이지 링크 설정 -->
<center>
<%
	if(count>0){
		// pageCount : 총페이지 수
		int pageCount = count/ page_size+((count%page_size==0)?0:1); //if를 안써도 삼항조건연산자 쓸 수 있다
		System.out.println("pageCount:"+pageCount);
		
		// startPage : 각 블럭의 시작 페이지 번호 : 1, 11, 21 ..
		// endPage : 각 블럭의 끝 페이지 번호 : 10, 20, 30..
		int startPage = ((currentPage-1)/10) * 10 + 1; //int형으로 나누기를 하기 때문에 소수점은 무조건 사라짐.따라서 1~10페이지까지 대입하면 startPage는 1이나옴
		int block = 10; // 1개의 블럭의 크기 : 10개의 페이지로 구성
		int endPage = startPage + block -1;
		
		// 가장 마지막 블럭에 endPage값을 pageCount로 수정
		if(endPage > pageCount){
			endPage = pageCount; // 마지막 블럭에서 총페이지수의 마지막 page까지만 설정이 되고 밑에 for문 돌리면 실제 존재하는 page까지만 출력된다.
		}
		
%>		
		<!-- 1page로 이동  -->
		<a href="list.jsp?page=1" style="text-decoration:none"> << </a>	
		<%-- style="text-decoration:none" 링크로 생긴 밑줄 없애는 CSS --%>
<%		
		// 이전 블럭으로 이동
		if(startPage > 10){
%>		
			<a href="list.jsp?page=<%=startPage-10%>"> [이전] </a>	
<% 		}

		// 각 블럭당 10개의 페이지 출력
		for(int i=startPage; i<=endPage; i++){
			if(i == currentPage){ 	// 현재 페이지
%>			
				[<%=i %>]
<%			}else{%>
				<a href = "list.jsp?page=<%=i%>">[<%=i %>]</a>
<% }
	}	// for end
	
		//다음 블럭으로 이동
		if(endPage < pageCount){
%>			
			<a href="list.jsp?page=<%=startPage+10%>"> [다음] </a>		
			
			
<%		}%>
		<!-- 마지막 페이지로 이동 -->
		<a href="list.jsp?page=<%=pageCount%>" style="text-decoration:none"> >> </a>
	
<%	
}
%>


</center>


</body>
</html>