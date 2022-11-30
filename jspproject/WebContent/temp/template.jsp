<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<% 
	String pagefile = request.getParameter("page");
	if(pagefile == null){ pagefile = "bestitem";}
%>    <%-- 초기화면으로 bestitem의 작성문이 인기상품 목록입니다.가 뜸.
		      초기값을 설정했기 때문에 값이 없을 때 500번 오류(코드오류)가 뜨지 않음 --%>
    
<html>
	<head><title>Template Test</title></head>
	<body>
	<table width=960 height=500 border=1 color=gray align=center>
		<tr><td height=43 colspan=3 align=left>
				<jsp:include page="top.jsp" />
			</td>
		</tr>
		<tr><td width=15% align=right valign=top>
				<jsp:include page="left.jsp" />
			</td>
			<td colspan=2 align=center>
				<jsp:include page='<%= pagefile+".jsp" %>'/>
			</td><%-- get방식의 page라는 변수로 값을 받아 .jsp를 붙여 페이지를 불러온다. --%>
		</tr>
		<tr><td width=100% height=40 colspan=3>
				<jsp:include page="bottom.jsp"/>
			</td>
		</tr>
	</table>
	</body>
</html>    