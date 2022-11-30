package p2022_01_03;

public class ConnectString {
	
    public static void main( String[] args ) {
	// String 객체 선언
	String gemini = "gemini";
	String johnharu = "johnharu";
		
	// 두 String 객체를 "+" 연산 수행
	String tempString1 = gemini + johnharu;  //값을 받는 tempString1과 같은 변수가 있다면 heap메모리상에 저장됨
	System.out.println( tempString1 );
	System.out.println( "gemini" + "johnharu" );//변수 없이 출력된 것은 일시적으로 저장하고 출력후 바로 삭제됨

	// String + 정수형
	String tempString2 = tempString1 + 100;
	System.out.println( tempString2 );
    }
}

