<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- header 파일 불러오기 -->
 <%@ include file="header.jsp" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
</head>
<body>

<form method="post" action="member.jsp">
	<table border=1 width=600 align="center">
		<caption>회원 가입 폼</caption>
		<tr>
			<th>ID</th>
			<td><input type=text name="id" id="id"
						autofocus="autofocus" value="toto" readonly="readonly">
						<!-- value로 toto를 초기값으로 나오게 하고
						     readonly는 읽기전용으로 만드는 것으로 toto를 수정 못하게한다 -->
				<input type="button" value="ID 중복검사">
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="passwd" id="passwd">
			</td>
		</tr>
		<tr>
			<th>성명</th>
			<td><input type=text name="name" id="name"></td>
		</tr>
		<tr>
			<th>주민번호</th>
			<td>
				<input type=text size=6 maxlength=6 name="jumin1" id="jumin1">
				<input type=text size=7 maxlength=7 name="jumin2" id="jumin2">
			</td>
		</tr>
		<tr>
			<th>E-Mail</th>
			<td><input type=text size=10 name="mailid" id="mailid">@
				<input type=text size=15 name="domain" id="domain">
				<select>
					<option value="">직접입력</option>
					<option value="naver.com">네이버</option>
					<option value="daum.net">다음</option>
					<option value="nate.com">네이트</option>
					<option value="gmail.com" selected="selected">구글</option>
					<!-- selected 속성: 가장 먼저 화면에 출력되도록 초기값으로 설정해주는 것 
						 속성 안 붙이면 가장 위에 있는 것이 초기값으로 설정된다.-->
				</select>
			</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>
				<input type=text size=4 maxlength=4 name="tel1" id="tel1">-
				<input type=text size=4 maxlength=4 name="tel2" id="tel2">-
				<input type=text size=4 maxlength=4 name="tel3" id="tel3">
			</td>
		</tr>
		<tr>
			<th>핸드폰</th>
			<td><select name="phone1" id="phone1">
					<option value="">직접입력</option>
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="018">018</option>
					<option value="019">019</option>
				</select>-
				<input type=text size=4 maxlength=4 name="phone2" id="phone2">-
				<input type=text size=4 maxlength=4 name="phone3" id="phone3">
			</td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td><input type=text size=5 maxlength=5 name="post" id="post">
				<input type="button" value="우편검색">
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type=text size=70 name="address" id="address"></td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<input type="radio" name="gender" value="남자">남자 
				<!-- radio 속성: 반드시 name값이 있어야한다.없으면 다중선택됨.
					 value 값도 넣어줘야 name값으로 데이터를 전달하고 name이 전달해줌 -->
				<input type="radio" name="gender" value="여자">여자
			</td>
		</tr>
		<tr>
			<th>취미</th>
			<td>
				<input type="checkbox" name=hobby value="공부" checked="checked">공부
				<input type="checkbox" name=hobby value="등산">등산
				<input type="checkbox" name=hobby value="게임">게임
				<input type="checkbox" name=hobby value="낚시">낚시
				<input type="checkbox" name=hobby value="쇼핑">쇼핑
				<!-- checkbox 속성: 다중항목 선택가능
				 	 checked 속성: 초기에 선택되어 있는 형태로 만듬 radio버튼 checkbox버튼 모두에 쓸 수 있음
				 -->
			</td>
		</tr>
		<tr>
			<th>자기소개</th>
			<td><textarea rows="5" cols="70"
					name="intro" id="intro"
					placeholder="자기소개를 100자 이내로 입력하세요"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan=2 align="center">
				<input type="submit" value="회원가입">
				<input type="reset" value="취소">
				
				<!-- 이미지 버튼: 전송 기능 있음 -->
				<!-- <input type="image" src="img/clock.jpg" width=30> -->
			</td>
		</tr>
	</table>

</form>


</body>
</html>

<!-- footer 파일 불러오기 -->
<%@ include file="footer.jsp" %>


