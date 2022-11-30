package p2022_01_03;

public class IndexOfTest {
	public static void main( String[] args ) {

// indexof() : 특정 문자의 인덱스 번호를 구해주는 메소드   <-> charAt()		
		
	String message = "Java program creates many objects.";

	int index1 = message.indexOf( 'a' );//가장 먼저 나오는 소문자a의 인덱스 번호를 구해준다.//1
	int index2 = message.indexOf( 97 );//97해당 아스키 코드인 소문자a의 인덱스 번호를 구한다.    //1

	System.out.println( index1 );
	System.out.println( index2 );

	//index번호 13번째 이후에서 a의 인덱스 번호를 구함
	int index3 = message.indexOf( 'a', 13 ); 
	System.out.println( index3 );

	int index4 = message.indexOf( "av" );
	System.out.println( index4 );
    //index번호 12번 이후에서 'man'의 인덱스 번호를 구함
	int index5 = message.indexOf( "man", 12 );
	System.out.println( index5 );
	// j가 소문자인데 문장에 없기 때문에 찾을 문자가 없을 경우에는 -1을 리턴한다.
	int index6 = message.indexOf( "java" );
	System.out.println( index6 );
    }
}



