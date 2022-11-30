package p2021_12_22;

import java.util.Scanner;

public class HomeWork2021_12_22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/// 키보드로 3개의 정수를 입력 받았을때 최대값과
//  최소값을 구하는 프로그램을 작성 하세요?
//  (단, 조건 연산자를 활용해서 작성하세요.)

		System.out.println("정수 3개를 입력하여 최대값과 최소값을 구하세요.");
		Scanner sc = new Scanner(System.in);

		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();

		int max = ((n1 > n2) ? n1 : n2) > n3 ? ((n1 > n2) ? n1 : n2) : n3; 
		int min = ((n1 < n2) ? n1 : n2) < n3 ? ((n1 < n2) ? n1 : n2) : n3;
		
		System.out.println("max:"+max);
		System.out.println("min:"+min);
		
		sc.close();
		
		
	}

}
