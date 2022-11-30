package p2022_01_12;

//try{
//	예외가 발생할 가능성이 있는 문장;
//  }catch(예외클래스명 매개변수){
//	예외 메시지;
//  }finally{
//	주로 파일을 닫을때, 데이터베이스 연결 끊을때 사용됨
//   예외가 발생하든, 발생하지 않든 무조건 실행됨;
//  }

public class MultiExceptionHandling1 {
    public static void main( String[] args ) {
		
	int value = 20;
	int div = 0;

	int[] intArray = { 1, 2, 3 };

	try {
	    // 두수의 나눗셈을 구함
	    int result = value / div;				//예외발생
	    System.out.println( result );

	    // 배열의 특정 값을 저장
            int arrayValue = intArray[4];		//예외발생
			System.out.println( arrayValue );

	    } catch ( ArithmeticException ae ) {
			System.out.println( ae.toString() );

	    } catch ( ArrayIndexOutOfBoundsException ai ) {
			ai.printStackTrace();

	    } finally {
	    	System.out.println("예외가 발생했음!");//예외가 발생하지 않더라도 실행됨

	    }	 
    }    
}



