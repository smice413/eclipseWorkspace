	$(document).ready(function(){
		
			// ID중복 검사
			$("#idcheck").click(function(){
				if($("#id").val() == ""){
					alert("ID를 입력하세요.");
					$("#id").focus();
					return false;
				}else{
					// open("팝업창에 실행될 문서명", "윈도우 이름", "옵션");
					var ref = "idcheck.jsp?id="+$("#id").val();
					window.open(ref,"mywin","width=250,height=150"); 
					//아이디 중복검사 중에 아이디값을 전달을 해주면 중복검사를 하는 것은 jsp에서 처리해야함
				}
				
			}); 
			// 주민번호 뒷자리로 포커스 이동
			$("#jumin1").keyup(function(){
				
				if($("#jumin1").val().length == 6)
					$("#jumin2").focus();
			});
			
			// 도메인 선택
			$("#email").change(function(){
				if($("#email").val() == ""){ 		//'직접입력' 선택
					$("#domain").val("").focus();
//					$("#domain").attr("readonly", false); //읽기전용 해제
					$("#domain").removeAttr("readonly");  //읽기전용 해제
				}else{								// 도메인 선택			
					$("#domain").val($("#email").val());
//					$("#domain").attr("readonly","readonly");
					$("#domain").attr("readonly", true); //readonly 대신 true로 써도 읽기전용이 된다. false쓰면 읽기전용해제됨
				}
				
			});
			
			
			
			
			// 유효성 검사
			$("form").submit(function(){
				
				var num = /^[0-9]+$/;
				
				if($("#id").val() == ""){
					alert("ID를 입력 하세요.");
					$("#id").focus();
					return false;
				}
				if($("#passwd").val() == ""){
					alert("비밀번호를 입력 하세요.");
					$("#passwd").focus();
					return false;
				}
				if($("#name").val() == ""){
					alert("이름을 입력 하세요.");
					$("#name").focus();
					return false;
				}
				if($("#jumin1").val() == ""){
					alert("주민번호 앞자리를 입력 하세요.");
					$("#jumin1").focus();
					return false;
				}
				if($("#jumin1").val().length != 6){
					alert("주민번호 앞자리 6자리를 입력 하세요.");
					$("#jumin1").val("").focus();
					return false;
				}
				// isNaN() : 문자가 포함되면 true를 리턴
//			    if(isNaN($("#jumin1").val())){
//					alert("숫자만 입력 하세요.");
//					$("#jumin1").val("").focus();
//					return false;
//				}
			    if(!num.test($("#jumin1").val())) { 	// test():pattern에 맞지 않으면 - false 리턴
			         alert("숫자만 가능합니다!");
					 $("#jumin1").val("");
					 $("#jumin1").focus();
			         return false; 
				} 
				if($("#jumin2").val() == ""){
					alert("주민번호 뒷자리를 입력 하세요.");
					$("#jumin2").focus();
					return false;
				}
				if($("#jumin2").val().length != 7){
					alert("주민번호 뒷자리 7자리를 입력 하세요.");
					$("#jumin2").val("").focus();
					return false;
				}
				// isNaN() : 문자가 포함되면 true를 리턴
//				 if(isNaN($("#jumin2").val())){
//					alert("숫자만 입력 하세요.");
//					$("#jumin2").val("").focus();
//					return false;
//				}
 				if(!num.test($("#jumin2").val())) { 	// test():pattern에 맞지 않으면 - false 리턴
			         alert("숫자만 가능합니다!");
					 $("#jumin2").val("");
					 $("#jumin2").focus();
			         return false; 
				}
				if($("#mailid").val() == ""){
					alert("EMail주소를 입력 하세요.");
					$("#mailid").focus();
					return false;
				}
				if($("#domain").val() == ""){
					alert("도메인명을 입력 하세요.");
					$("#domain").focus();
					return false;
				}
				if($("#tel1").val() == ""){
					alert("전화번호 앞자리를 입력 하세요.");
					$("#tel1").focus();
					return false;
				}
				if(isNaN($("#tel1").val())){
					alert("숫자만 입력 하세요.");
					$("#tel1").val("").focus();
					return false;
				}
				if($("#tel2").val() == ""){
					alert("전화번호 중간자리를 입력 하세요.");
					$("#tel2").focus();
					return false;
				}
				if(isNaN($("#tel2").val())){
					alert("숫자만 입력 하세요.");
					$("#tel2").val("").focus();
					return false;
				}
				if($("#tel3").val() == ""){
					alert("전화번호 끝자리를 입력 하세요.");
					$("#tel3").focus();
					return false;
				}
				if(isNaN($("#tel3").val())){
					alert("숫자만 입력 하세요.");
					$("#tel3").val("").focus();
					return false;
				}
				if($("#phone1").val() == ""){
					alert("핸드폰 번호 앞자리를 선택 하세요.");
					$("#phone1").focus();
					return false;
				}
				if($("#phone2").val() == ""){
					alert("핸드폰 번호 중간자리를 입력 하세요.");
					$("#phone2").focus();
					return false;
				}
				if(isNaN($("#phone2").val())){
					alert("숫자만 입력 하세요.");
					$("#phone2").val("").focus();
					return false;
				}
				if($("#phone3").val() == ""){
					alert("핸드폰 번호 끝자리를 입력 하세요.");
					$("#phone3").focus();
					return false;
				}
				if(isNaN($("#phone3").val())){
					alert("숫자만 입력 하세요.");
					$("#phone3").val("").focus();
					return false;
				}
				if($("#post").val() == ""){
					alert("우편번호를 입력 하세요.");
					$("#post").focus();
					return false;
				}
				if($("#address").val() == ""){
					alert("주소를 입력 하세요.");
					$("#address").focus();
					return false;
				}
				if($("#male").is(":checked") == false &&
				   $("female").is(":checked") == false){ 	//is() : 체크가 되어 있다면 true
					alert("성별을 선택 하세요.");
				    return false;
				}
				
//				 var cnt = 0;
//				if($("#h1").is(":checked")) cnt++;
//				if($("#h2").is(":checked")) cnt++;
//				if($("#h3").is(":checked")) cnt++;
//				if($("#h4").is(":checked")) cnt++;
//				if($("#h5").is(":checked")) cnt++;
				
//				if(cnt < 2){
//					alert("취미를 2개 이상 선택하세요.");
//					return false;
//				} 
				
				if($("input:checkbox[name='hobby']:checked").length < 2){ 
					//input태그 안에 checkbox를 모두 구해오고 그중에 name값이 hobby인것이며 체크가 되어 있는 것으로 구해와라
					// 쌍따옴표 안에 쌍따옴표 안되고 외따옴표해야함. 또는 외따옴표가 바깥에 있으면 안에는 쌍따옴표로 해야함.
					alert("취미를 2개 이상 선택하세요.");
					return false;
				}
				if($("#intro").val() == ""){
					alert("자기소개를 입력 하세요.");
					$("#intro").focus();
					return false;
				}
				if($("#intro").val().length > 100){
					alert("자기소개를 100자 이내로 입력하세요.");
					$("#intro").focus();
					return false;
				}
				
			});// submit() end
		
	});