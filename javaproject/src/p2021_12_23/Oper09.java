package p2021_12_23;

public class Oper09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// 확장 대입 연산자
//+=, -=, *=, /=, %=
//  ex)   a+=b;	// a = a + b;   즉, a+b 연산을 수행 후 a변수에 할당해라 라는 의미
//        a-=b; // a = a - b;
//        a*=b; // a = a * b;
//        a/=b; // a = a / b;
//        a%=b;	// a = a % b;
		
		int a= 10, b= 3;
		System.out.println(a+=b); //a=a+b 13
		System.out.println(a-=b); //a=a-b 10 위의 결과 a에 누적되서 나온 a결과 
		System.out.println(a*=b); //a=a*b 30 위의 결과 a에 누적되서 나온 a결과
		System.out.println(a/=b); //a=a/b 10 위의 결과 a에 누적되서 나온 a결과
		System.out.println(a%=b); //a=a%b 1   위의 결과 a에 누적되서 나온 a결과
		
		
		
		
		
		
		
		
	}

}
