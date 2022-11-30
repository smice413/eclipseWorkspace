package p2022_01_13;

// 입출력에 관한 패키지 import
import java.io.InputStream;

public class InputStreamTest {
//입출력 데이터베이스는 예외처리를 무조건 해야한다. 안하면 컴파일상 오류발생함.
    public static void main( String[] args ) throws Exception {//throws Exception은 자바가상머신한테 예외처리를 자동으로 하게 넘기는 것.
																//try catch 대신 이렇게 써도 된다.
	// InputStream 객체 생성
	//System.in은 표준입력 장치인 키보드로 부터 입력 받는것을 의미함.
	InputStream is = System.in; // InputStream 필드 자료형을 is로 객체화 하기 위함.System클래스에서의 필드 호출 방식이.in이다. 
	int inputValue = 0;			//1byte 입력 시스템이기 때문에 1글자만 가능.

	System.out.print( "Input Data : " );

//	try {
//		// 키보드로부터 값을 입력 받음
//		//read() 메소드는 1바이트를 읽어들여서 
//		//ascii 코드(0~127)값으로 casting함.
		inputValue = is.read(); 			//a 입력   //inputValue 변수에 97이 저장됨. is.read();로 입력값이 들어간다.
//	} catch ( IOException io ) {
//	//	System.out.print(io.toString());
//		System.out.print(io.getMessage());
//	}//한글 처리를 못함.
	
System.out.println( "InputData is " + inputValue );	
System.out.println( "InputData is " + (char)inputValue );
	}
}

		