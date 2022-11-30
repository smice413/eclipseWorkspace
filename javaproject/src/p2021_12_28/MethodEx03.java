package p2021_12_28;

import java.util.Scanner;

public class MethodEx03 {

// 키보드로 입력한 2개의 정수 중에서  최대값과 최소값을 구하는 프로그램을 작성하세요
// 단, 메소드를 이용해서 작성 하세요?		
	
	//최대값
	static int max(int a, int b) {
		if(a>b) 
			return a;
		else 
			return b;
	}
	//최소값
	static int min(int a, int b) {
		if(a<b) 
			return a;
		else 
			return b;
	}
	
	
	
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1, n2, max, min;
		System.out.println("정수 2개를 입력하세요?");
		Scanner sc = new Scanner(System.in);
		
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		
		max= MethodEx03.max(n1, n2);//max()메소드를 호출하라는 의미. MethodEx03.은 같은 Class에 있기 때문에 생략가능.
		min= min(n1, n2);
		System.out.println("max:"+max);
		System.out.println("min:"+min);
		
		
		
		
	}

}
