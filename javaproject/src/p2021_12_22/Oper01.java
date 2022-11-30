package p2021_12_22;

public class Oper01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 산술 연산자:+,-,*,/(몫),%(나머지를 구해줌 나머지가 1이면 홀수라는 것 알 수 있고0이면 짝수)
		// int형과 int형을 산술연산을 수행하면, 결과는 int형으로 처리된다. 즉, 같은 자료형끼리면 같은 자료형으로 처리
		int a = 10, b = 3, c;
		
		c = a + b;
		System.out.println("a+b="+c);    //13
		System.out.println("a+b="+(a+b));//13
		System.out.println("a-b="+(a-b));//7
		System.out.println("a*b="+(a*b));//30
		System.out.println("a/b="+(a/b));//3(몫)
		System.out.println("a%b="+(a%b));//1(나머지)
		
		
		
		
		
		
	}

}
