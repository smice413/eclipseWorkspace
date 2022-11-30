package p2022_01_03;

public class FindBlankIndex {
    public static void main( String[] args ) {
		
	String message = "Java program creates many objects.";
	
	// message의 길이를 구함.
	// length() : 문자열의 길이를 구해준다. 글자수를 구해줌. //배열의 크기: .length이다. 괄호 없음.메소드 아니고 속성이기 때문.
	int len = message.length();

	System.out.println(len);  // len = 34;

	// message 중에서 ' '을 찾음
	for( int i=0 ; i<len ; i++ ) {
	    char c = message.charAt( i );//charAt(index 번호): 번호에 해당하는 문자를 char형으로 받는 것.
		if( c == ' ' ) {
		    System.out.println( "index = " + i );
		}
	}//for end
    }
}
