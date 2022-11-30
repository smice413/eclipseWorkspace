<%@ page contentType="text/html;charset=utf-8"%>
<!-- 현재문서상에서 text값을 utf-8로 인코딩해서 출력하라는 의미 -->

<%	// 1.폼파일에서 한글값이 get방식으로 전송될때는 tomcat이 자동으로 utf-8로 인코딩시켜줌.
	// 2.폼파일에서 한글값이 post방식으로 전송될때 utf-8로 인코딩을 시켜주는 역할. 
	//   post방식은 tomcat이 자동으로 안해주기 때문에 반드시 따로 설정해야함.
	request.setCharacterEncoding("utf-8");//인코딩 코드를 가장 위에 써야 한다. 밑에 변수값을 받고 나서 쓰면 한글이 깨진다.
%>

<html>
<h1>Request 객체1</h1>

<%
	String name = request.getParameter("name"); //변수명 대소문자 구분해서 값을 받는다.안받아지면 null값이 뜸.
	String studentNum = request.getParameter("studentNum");
	String gender = request.getParameter("gender");
	String major = request.getParameter("major");
/* 
	if(gender.equals("m")){
		gender = "남자";
	}else{
		gender = "여자";
	} */
%>

<body>
성명: <%=name%><p>
학번: <%=studentNum%><p>
성별 : <%=gender%><p>
전공 : <%=major%>
</body>
</html>

