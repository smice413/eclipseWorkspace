package p2021_12_22;

import java.util.Scanner;

public class Oper05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("정수 2개를 입력 하세요?");// 출력
		// System.~~이 것을 정적필드(따로 객체를 선언(new연사자 사용하여)하지 않아도 쓸 수 있기 때문)라고 한다.
		// Fields(=멤버변수)
		Scanner sc = new Scanner(System.in);// System.in을 쓰는 이유는 콘솔창에서 키보드로 칠 것이기 때문
		// Scanner클래스만 예외처리 하지 않고 입력 가능, 반드시 new 연산자 써라

		int n1 = sc.nextInt(); // 스페이스바 or 엔터키로 구분함.
		//즉, 콘솔창에 10을 쓰고 스페이스바 누룬뒤 20쓰고 엔터를 치면 결과 나옴 혹은 반대로 하면됨
		
		int n2 = sc.nextInt();
		
		System.out.println("n1:"+n1);
		System.out.println("n2:"+n2);
		
		if(n1>n2 ) {
			System.out.println(n1+"이"+n2+"보다 크다");
		}else {
			System.out.println(n2+"이"+n1+"보다 크다");
		}
		
		sc.close();
		

	}

}
