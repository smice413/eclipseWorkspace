package p2022_01_12;

public class ThrowsExceptionHandling1 {
	//occurException()를 호출한 곳으로 예외처리를 양도 하겠다는 의미
    public void occurException() throws ArithmeticException {
	 
		// ArithmethicException 발생
		int result = 3/0;
		System.out.println( result );	 
    }

    public static void main( String[] args ) {
		// 객체를 생성
ThrowsExceptionHandling1 te = new ThrowsExceptionHandling1();

	// try-catch 블록으로 예외 처리
	try {
		te.occurException();
	} catch ( ArithmeticException ae ) { //ArithmeticExceptiom 대신 Exception으로 써도 됨. 위의 호출받은 메소드에서 양도 받은 throws ArithmeticException을 catch로 받은것이기 때문.
										//따라서 위의 메소드에는 throws Exception을 써버리면 클래스가 최상위이기 때문에 catch에서 받을 수 없음. 
		System.out.println( "Exception이 발생 : " + ae.toString());//ae.toString: 예외메시지를 출력해줌 
		System.out.println( "0으로 나눌 수 없습니다." );
	}
    }
}

