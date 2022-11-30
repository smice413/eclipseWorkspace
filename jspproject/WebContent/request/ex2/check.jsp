<%@ page contentType="text/html;charset=utf-8"%>

<html>
<body>

	<%
		request.setCharacterEncoding("utf-8"); //post방식으로 전달받기 때문에 인코딩 코드 작성

		String[] choice = request.getParameterValues("site"); 
		/* java언어로는 하나의 name값으로 value값을 받을 수 있는 메소드가 있지만, 언어가 다르면 name을 다 다르게 해야한다. */
		String result = "";

		for (int i = 0; i < choice.length; i++) {
			result = result + choice[i] + " ";
		}
	%>

	<center>
		귀하는 <font color=blue><%=result%></font> 를 좋아하시는군요.
	</center>

</body>
</html>