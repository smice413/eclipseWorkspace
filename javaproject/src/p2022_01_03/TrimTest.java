package p2022_01_03;

public class TrimTest {
    
	//.trim()은 문자열의 좌우 공백을 없애주는 역할
    // boolean equals() : 문자열 값을 비교하는 역할
	
	public static void main( String[] args ) {
	String str1 = new String( "gemini   " );//공백도 데이터로 인식함. 따라서 값이 다름
	String str2 = new String( "   gemini " );
	
	System.out.println(str1.trim());
	
	System.out.println( str1.equals( str2 ));			//false
	System.out.println( str1.trim().equals( str2.trim()));//true
    }
}
		