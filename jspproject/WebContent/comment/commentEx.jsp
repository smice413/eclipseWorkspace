<%@ page contentType="text/html;charset=euc-kr" %>

<html>
	<body>


<h1>Comment Example</h1>

<%
   String name = "Korea";
%>
<!-- 웹브라우저 상에 들어가는 소스코드는 html이기 때문에 jsp코드는 브라우저 상에 드러나지 않게 된다.
따라서 태그 안에 있는 내용은  소스보기로도 드러나지 않는 것이다. jsp코드는 tomcat서버에서 처리하고
html코드로 변환된 다음에 브라우저 상에 띄우는 것이기 때문에 보안상 jsp주석을 쓰는 것이 좋다.-->
<!-- html 주석 부분입니다. '소스보기'에서 보이지요. -->

<%-- 
     이 부분은 JSP 페이지에서만 보이고 '소스보기'를 해도 보이지 않습니다.
     브라우저에 보내지 않는 문장입니다. 
--%>

<!-- <%=name%> html주석에서도 동적인 변수 사용(주석 처리되지만 브라우저에서 소스보기로 출력됨) -->

<%-- <%=name%> jsp주석 --%> <!-- 소스보기 상에서도 보이지 않음  -->

<%=name /* 표현식의 주석 부분 입니다*/ %> Fighting!!!

	</body>
</html>

