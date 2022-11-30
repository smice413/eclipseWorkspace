package p2022_01_12;

public class MultiExceptionHandling {
	public static void main(String[] args) {

		int value = 20;
		int div = 0;
		int[] intArray = { 1, 2, 3 };
// 		intArray[0]=1, intArray[1]=2, intArray[2]=3
		
		try {	//예외가 발생할 것 같은 것들에서 가장 먼저 발생한 예외에 따라  맞는 catch로 던져서 실행됨. 첫 예외가 해결되어야 다른 예외가 catch로 던져짐.
			int arrayValue = intArray[4]; //4번 방에 원소값을 불러와라. 배열의 범위를 벗어남. 오류발생
			System.out.println(arrayValue);

			// 두수의 나눗셈을 구함
			int result = value / div;
			System.out.println(result);

			// 배열의 특정 값을 저장
//          int arrayValue = intArray[4];
//		  System.out.println( arrayValue );	    

		} catch (ArithmeticException ae) {
			System.out.println(ae.toString());
			System.out.println("0으로 나눌수 없습니다.");
		} catch (ArrayIndexOutOfBoundsException ai) { //배열범위 벗어나 오류난 것이 이곳 두번째 catch로 던져짐.
			ai.printStackTrace();
			System.out.println("배열의 범위를 벗어났습니다.");
		}
	}
}
