<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="color.jsp"%>
<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="check.js"></script>
</head>

<% 
  int num=0,ref=1,re_step=0,re_level=0;	// 원문. 
  String nowpage = "";
  // ref=1은  시퀀스가 설정되어 있기 때문에 굳이 초기값1을 선언안해도 됨.
// 이 4개의 변수값을 꼭 전달 안해도된다 왜냐하면 자바빈 형성시 자동으로 초기값이 0으로 설정됨
 	
  if(request.getParameter("num")!=null){  // 답글
	num=Integer.parseInt(request.getParameter("num"));
	ref=Integer.parseInt(request.getParameter("ref"));
	re_step=Integer.parseInt(request.getParameter("re_step"));
	re_level=Integer.parseInt(request.getParameter("re_level"));
	nowpage = request.getParameter("page");
  }
%>
   
<body bgcolor="<%=bodyback_c%>">  
<center><b>글쓰기</b>
<br>
<form method="post"  action="replyPro.jsp">
<input type="hidden" name="num" value="<%=num%>">
<input type="hidden" name="ref" value="<%=ref%>">
<input type="hidden" name="re_step" value="<%=re_step%>">
<input type="hidden" name="re_level" value="<%=re_level%>">
<input type="hidden" name="page" value="<%=nowpage%>">

<table width="400" border="1" cellspacing="0" cellpadding="0"  bgcolor="<%=bodyback_c%>" align="center">
   <tr>
    <td align="right" colspan="2" bgcolor="<%=value_c%>">
	    <a href="list.jsp?page=<%=nowpage%>"> 글목록</a> 
   </td>
   </tr>
   <tr>
    <td  width="70"  bgcolor="<%=value_c%>" align="center">이 름</td>
    <td  width="330">
       <input type="text" size="10" maxlength="10" id="writer" name="writer"></td>
  </tr>
  <tr>
    <td  width="70"  bgcolor="<%=value_c%>" align="center" >제 목</td>
    <td  width="330">
    <%if(request.getParameter("num")==null){%> <!--  원문 -->
       <input type="text" size="40" maxlength="50" id="subject" name="subject"></td>
	<%}else{%>									<!-- 답글 -->
	   <input type="text" size="40" maxlength="50" id="subject" name="subject" value="Re."></td>
	<%}%>
  </tr>
  <tr>
    <td  width="70"  bgcolor="<%=value_c%>" align="center">Email</td>
    <td  width="330">
       <input type="text" size="40" maxlength="30" id="email" name="email" ></td>
  </tr>
  <tr>
    <td  width="70"  bgcolor="<%=value_c%>" align="center" >내 용</td>
    <td  width="330" >
     <textarea id="content" name="content" rows="13" cols="40"></textarea> </td>
  </tr>
  <tr>
    <td  width="70"  bgcolor="<%=value_c%>" align="center" >비밀번호</td>
    <td  width="330" >
     <input type="password" size="8" maxlength="12" id="passwd" name="passwd"> 
	 </td>
  </tr>
<tr>      
 <td colspan=2 bgcolor="<%=value_c%>" align="center"> 
  <input type="submit" value="글쓰기" >  
  <input type="reset" value="다시작성">
  <input type="button" value="목록보기" OnClick="window.location='list.jsp?page=<%=nowpage%>'">
</td></tr></table>    
    
</form>      
</body>
</html>      
