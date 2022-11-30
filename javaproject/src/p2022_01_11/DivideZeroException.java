package p2022_01_11;

//예외처리를 하지 않은 경우
public class DivideZeroException {
    public static void main( String[] args ) {
    	
	// int type의 변수 선언
 	int b = 20;
	int a = 0;

	// 두 수의 나눗셈 결과를 구한다
	int c = b / a;			//예외발생: 컴퓨터가 0으로 나누는 것을 인식못함.
	int total = a + b;
	int sub = b-a;
	
	System.out.println( c );
   }
}

		