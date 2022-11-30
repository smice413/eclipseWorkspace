package p2021_12_22;

public class Oper03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 비교 연산자: >, <, >=, <=, ==(같다), !=(같지않다)
		// 비교 연산자의 결과가 참이면 true, 거짓이면 false 값을 리턴(왼쪽에 있는 변수에게 돌려준다)한다.

		int num1 = 10;
		int num2 = 10;

		boolean result1 = (num1 == num2);
		boolean result2 = (num1 != num2);
		boolean result3 = (num1 <= num2);

		System.out.println("result1:" + result1);
		System.out.println("result1:" + result2);
		System.out.println("result1:" + result3);

		System.out.println(num1 < num2);
		System.out.println(10 < 20);

		char c1 = 'A';//65
		char c2 = 'B';//66

		System.out.println(c1 < c2);

	}

}
