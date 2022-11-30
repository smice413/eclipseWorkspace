package service;

public class ActionForward {

	
	private boolean redirect;		//포워딩 방식 설정
	private String path;			//포워딩 페이지명 설정 
	
	public boolean isRedirect() {	//getRedirect()가 아니다. 이유: boolean형이기 때문? //컨트롤러클래스에서 set값을 받아 is로 실제 포워딩처리함
		return redirect;
	}
	public void setRedirect(boolean redirect) {  //서비스 클래스 하단에 설정
		this.redirect = redirect;
	}
	public String getPath() { 					//컨트롤러클래스에서 set값을 받아 get으로 실제 path처리함
		return path;
	}
	public void setPath(String path) { //서비스 클래스 하단에 설정
		this.path = path;
	}
}
