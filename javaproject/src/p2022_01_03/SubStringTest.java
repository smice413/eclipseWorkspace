package p2022_01_03;

//substring(n) : index번호 n번 부터 끝까지 문자열을 추출
//substring(n1, n2) : index번호 n1번 부터 (n2-1)번 까지 문자열을 추출
		    
public class SubStringTest {
    public static void main( String[] args ) {
		
	String message = "Java program creates many objects.";
	
	//인덱스 번호 13번 부터 끝까지 문자열 추출
	String str1 = message.substring( 13 );
	System.out.println( str1 );

	//인덱스 번호 13번 부터 15까지 문자열 추출
	String str2 = message.substring( 13, 16 );
	System.out.println( str2 );
    }
}
