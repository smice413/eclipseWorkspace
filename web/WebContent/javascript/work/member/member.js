// ID중복 검사
	function idcheck(){
		var id = document.getElementById("id");
		if(id.value == ""){
			alert("Id를 입력하세요.");
			id.focus();
			return false;
		}else{
			var ref = "idcheck.jsp?id="+id.value; 
			//idcheck.jsp라는 파일을 get방식으로 전달하기 때문에 ?로 넣는다.
			//?뒤의 id는 변수명으로 임의로 정해주고(위의 고정된 id값 아님.) jsp파일에서 똑같이 id라는 변수명으로 값을 받는다.		
			window.open(ref,"idcheck","width=300, height=200");
		}
		
	}
	// 주민번호 뒷자리로 포커스 이동
	function move(){
		var jumin1 = document.getElementById("jumin1");
		var jumin2 = document.getElementById("jumin2");
		
		if(jumin1.value.length == 6){
			jumin2.focus();
		}
	}
	
	// 도메인 선택
	function sel(){ //도메인과 직접입력을을 구분해서 함수를 작성한다.이유는 이벤트를 각각 다르게 부여해야 하기 때문
		var domain = document.getElementById("domain");
		var email = document.getElementById("email");
		
		if(email.value == ""){		 //"직접입력"을 선택한 경우
			domain.readOnly = false; //읽기 전용 해제
			domain.value = "";
			domain.focus();
		}else{						 //도메인을 선택한 경우
			domain.value = email.value;
			domain.readOnly = true;	 //읽기만 가능함.
		}
		
	}
	
	// 유효성 검사 : 회원가입 버튼을 눌렀을 때 ID 작성 부터 끝까지 유효성 검사 처리하는 것
	function check(){
		var id = document.getElementById("id"); // JQuery 에서는 $(#id); 이런식으로 코드가 간결해짐.
		var passwd = document.getElementById("passwd");
		var name = document.getElementById("name");
		var jumin1 = document.getElementById("jumin1");
		var jumin2 = document.getElementById("jumin2");
		var mailid = document.getElementById("mailid");
		var domain = document.getElementById("domain");
		var tel1 = document.getElementById("tel1");
		var tel2 = document.getElementById("tel2");
		var tel3 = document.getElementById("tel3");
		var phone1 = document.getElementById("phone1");
		var phone2 = document.getElementById("phone2");
		var phone3 = document.getElementById("phone3");
		var post = document.getElementById("post");
		var address = document.getElementById("address");
		var male = document.getElementById("male");
		var female = document.getElementById("female");
		var h1 = document.getElementById("h1");
		var h2 = document.getElementById("h2");
		var h3 = document.getElementById("h3");
		var h4 = document.getElementById("h4");
		var h5 = document.getElementById("h5");
		var intro = document.getElementById("intro");
		
		if(id.value == ""){
			alert("ID를 입력 하세요.");
			id.focus();
			return false; //함수문을 빠져 나감.
		}
		if(passwd.value == ""){
			alert("비밀번호를 입력 하세요.");
			passwd.focus();
			return false; //함수문을 빠져 나감.
		}
		if(name.value == ""){
			alert("이름를 입력 하세요.");
			name.focus();
			return false; //함수문을 빠져 나감.
		}
		if(jumin1.value == ""){
			alert("주민번호 앞자리를 입력 하세요.");
			jumin1.focus();
			return false; //함수문을 빠져 나감.
		}
		if(jumin1.value.length != 6){
			alert("주민번호 앞자리 6자리를 입력 하세요.");
			jumin1.value = "";
			jumin1.focus();
			return false; //함수문을 빠져 나감.
		}
		// isNan() : 문자가 포함되면  true를 리턴
		if(isNaN(jumin1.value)){
			alert("숫자만 입력 하세요.");
			jumin1.value = "";
			jumin1.focus();
			return false; //함수문을 빠져 나감.
		}
		if(jumin2.value == ""){
			alert("주민번호 뒷자리를 입력 하세요.");
			jumin2.focus();
			return false; //함수문을 빠져 나감.
		}
		if(jumin2.value.length != 7){
			alert("주민번호 뒷자리 7자리를 입력 하세요.");
			jumin2.value = "";
			jumin2.focus();
			return false; //함수문을 빠져 나감.
		}
		// isNan() : 문자가 포함되면  true를 리턴
		if(isNaN(jumin2.value)){
			alert("숫자만 입력 하세요.");
			jumin2.value = "";
			jumin2.focus();
			return false; //함수문을 빠져 나감.
		}
		if(mailid.value == ""){
			alert("EMail주소를 입력 하세요.");
			mailid.focus();
			return false; //함수문을 빠져 나감.
		}
		if(domain.value == ""){
			alert("도메인을 입력 하세요.");
			domain.focus();
			return false; //함수문을 빠져 나감.
		}
		if(tel1.value == ""){
			alert("전화번호 앞자리를 입력 하세요.");
			tel1.focus();
			return false; //함수문을 빠져 나감.
		}
		// isNan() : 문자가 포함되면  true를 리턴
		if(isNaN(tel1.value)){
			alert("숫자만 입력 하세요.");
			tel1.value = "";
			tel1.focus();
			return false; //함수문을 빠져 나감.
		}
		if(tel2.value == ""){
			alert("전화번호 중간자리를 입력 하세요.");
			tel2.focus();
			return false; //함수문을 빠져 나감.
		}
		// isNan() : 문자가 포함되면  true를 리턴
		if(isNaN(tel2.value)){
			alert("숫자만 입력 하세요.");
			tel2.value = "";
			tel2.focus();
			return false; //함수문을 빠져 나감.
		}
		if(tel3.value == ""){
			alert("전화번호 끝자리를 입력 하세요.");
			tel3.focus();
			return false; //함수문을 빠져 나감.
		}
		// isNan() : 문자가 포함되면  true를 리턴
		if(isNaN(tel3.value)){
			alert("숫자만 입력 하세요.");
			tel3.value = "";
			tel3.focus();
			return false; //함수문을 빠져 나감.
		}
		if(phone1.value == ""){
			alert("핸드폰 앞자리를 선택 하세요.");
			phone1.focus();
			return false; //함수문을 빠져 나감.
		}
		if(phone2.value == ""){
			alert("핸드폰 중간자리를 입력 하세요.");
			phone2.focus();
			return false; //함수문을 빠져 나감.
		}
		// isNan() : 문자가 포함되면  true를 리턴
		if(isNaN(phone2.value)){
			alert("숫자만 입력 하세요.");
			phone2.value = "";
			phone2.focus();
			return false; //함수문을 빠져 나감.
		}
		if(phone3.value == ""){
			alert("핸드폰 끝자리를 입력 하세요.");
			phone3.focus();
			return false; //함수문을 빠져 나감.
		}
		// isNan() : 문자가 포함되면  true를 리턴
		if(isNaN(phone3.value)){
			alert("숫자만 입력 하세요.");
			phone3.value = "";
			phone3.focus();
			return false; //함수문을 빠져 나감.
		}
		if(post.value == ""){
			alert("우편번호를 입력 하세요.");
			post.focus();
			return false; //함수문을 빠져 나감.
		}
		if(address.value == ""){
			alert("주소를 입력 하세요.");
			address.focus();
			return false; //함수문을 빠져 나감.
		}
		if(male.checked == false && female.checked == false){ //남자 여자 둘다 선택되지 않은 경우
			alert("성별을 선택하세요.");
			return false;
			
		}
		
		var cnt = 0;
		if(h1.checked) cnt++; //cnt 변수에 체크박스에 체크한 값을 저장. h1을 체크하면 cnt변수 값이 1 증가.
		if(h2.checked) cnt++; // 체크박스를 선택할 수록 cnt값 누적됨.
		if(h3.checked) cnt++;
		if(h4.checked) cnt++;
		if(h5.checked) cnt++;
		
		if(cnt < 2){
			alert("취미를 2개이상 선택 하세요.");
			return false;
		}
		if(intro.value == ""){
			alert("자기소개를 입력 하세요.");
			intro.focus();
			return false; //함수문을 빠져 나감.
		}
		if(intro.value.length > 100){
			alert("자기소개를 100자 까지 입력 하세요.");
			intro.focus();
			return false; //함수문을 빠져 나감.
		}
	}