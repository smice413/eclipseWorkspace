package p2022_01_12;

public class UserDefineException extends Exception {
//			 사용자 정의 예외처리 클래스 : 생성자만 가지고 있다.
    // 기본 생성자
    public UserDefineException() {
    }

    // 인수를 하나 받아들이는 생성자
    public UserDefineException( String information ) {
		// Exception 클래스의 생성자 호출
		super( information ); //super() 자기 부모 클래스의 생성자 호출하라 super.은 부모클래스의 은닉된 메소드 핃드 호출
    }
}
