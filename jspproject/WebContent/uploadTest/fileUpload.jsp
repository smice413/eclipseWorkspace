<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %> <!-- MultipartRequest: 첨부파일을 서버쪽으로 업로드하는 역할 -->
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %> <!-- DefaultFileRenamePolicy: 중복문제를 해결해주는 클래스 -->
<%@ page import="java.util.*" %>
<%
//	String na = request.getParameter("name");// mutipartRequest클래스를 쓰면서 이 방식으로는 값전달 안됨.이 클래스에서 제공되는 메소드로 가능함.
//	System.out.println("name:"+na); //null값 나옴 밑의 multi.getParameter("name")로 받아야 값을 전달 받을 수 있다.	

	// 업로드할 디렉토리 위치를 구해옴
	String uploadPath=request.getRealPath("upload"); //업로드될 실제 디렉토리(즉,upload폴더)경로를 알려줌
	System.out.println("path="+uploadPath);	

	int size = 10*1024*1024;	// 첨부파일의 크기(단위:byte) : 10MB
	String name="";
	String subject="";
	String filename1="";
	String filename2="";
	String origfilename1="";
	String origfilename2="";
	
	try{ // 첨부파일은 MultipartRequest 객체를 생성 하면서 업로드 된다.
		MultipartRequest multi=new MultipartRequest(request,
							uploadPath, 		// 업로드할 디렉토리 위치
							size, 				// 첨부파일의 크기 : 10MB
							"utf-8",			// 인코딩 타입 설정 :한글값 안깨지게함
				new DefaultFileRenamePolicy()); // 중복 문제 해결

		name=multi.getParameter("name");
		subject=multi.getParameter("subject");
		
		// 열거형 : files = "fileName1", "fileName2" 즉, name값을 구해옴
		Enumeration files=multi.getFileNames();
		
//	    String file1 = "fileName1";
		String file1 =(String)files.nextElement();
		filename1=multi.getFilesystemName(file1); //실제 서버에 저장된 파일명. 중복된 파일이면 숫자가 뒤에 붙어있다(koala1.jpg).
		origfilename1= multi.getOriginalFileName(file1);// 클라이언트가 업로드한 파일명(koala.jpg)

// 	    String file2 = "fileName2";		
		String file2 =(String)files.nextElement();
		filename2=multi.getFilesystemName(file2);
		origfilename2=multi.getOriginalFileName(file2);
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<html>
<body>
<form name="filecheck" action="fileCheck.jsp" method="post">
	<input type="hidden" name="name" value="<%=name%>">
	<input type="hidden" name="subject" value="<%=subject%>">
	<input type="hidden" name="filename1" value="<%=filename1%>">
	<input type="hidden" name="filename2" value="<%=filename2%>">
	<input type="hidden" name="origfilename1" value="<%=origfilename1%>">
	<input type="hidden" name="origfilename2" value="<%=origfilename2%>">
</form>
<a href="#" onclick="javascript:filecheck.submit()">업로드 확인 및 다운로드 페이지 이동</a>
</body>
</html>
