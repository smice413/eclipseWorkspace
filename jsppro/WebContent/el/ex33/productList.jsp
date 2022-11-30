<%@ page language="java" contentType="text/html; charset=utf-8"
%>

<html>

	<head>
		
<meta charset="utf-8">

		<title>EL 예제</title>

	</head>

	<body>

	<center>
		<H2>EL 예제-상품목록</H2>
		<HR>
	<form method="post" action="productSel.jsp">
		<jsp:useBean id="product" class="jspbook.Product" scope="session"/>
		<select name="sel">
			<%
			// session 에서 가져온 Product 객체로 부터 저장되어 있는 목록을 가져와 출력함.
			for(String item : product.getProductList()) {
				out.println("<option>"+item+"</option>");
			}
			%>
		</select>
		<input type="submit" value="선택"/>
	</form>
	</center>
</body>

</html>