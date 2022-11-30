package beans;


public class LoginBean {	
	
	private String userid;	// 로그인폼에서 전달된 값을 저장
	private String passwd;	

	private String _userid;	// myuser //DB에 저장된 회원정보라고 생각하면 됨.실제 DB와 연동된 것은 아님
	private String _passwd;	// 1234	  //따라서 저장된 회원 정보대로 입력하지 않으면 로그인을 성공하지 못함.
	
	// 생성자
	public LoginBean() {
		// 인증에 사용할 기본값 설정 //DB에 저장된 회원정보
		_userid = "myuser";
		_passwd = "1234";
	}
	
	// 아이디와 비밀번호가 맞는지 체크하는 메서드
	public boolean checkUser() {
		if(userid.equals(_userid) && passwd.equals(_passwd))
			return true;	//일치
		else
			return false;	//일치되지 않는 경우
	}		
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}	
	
	public String getUserid() {
		return userid;
	}
	
	public String getPasswd() {
		return passwd;
	}
}