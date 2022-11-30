package p2021_12_23;

import java.util.Scanner;

public class HomeWork2021_12_23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		
//		 키보드를 이용해서 입력한 정수의 팩토리얼을
//		   구하는 프로그램을 작성 하세요?
//			ex) 3! = 3 * 2 * 1
//		        5! = 5 * 4 * 3 * 2 * 1
		// 변수 선언을 2개 해야함 for문에 반복될 수와 결과값을 나타내는 수

		int i, rs = 1;

		System.out.println("정수를 입력하시오.");
		Scanner sc = new Scanner(System.in);

		i = sc.nextInt();
		// 입력 받은 값이 0 또는 음수일때
		if (i <= 0) {
			System.out.println("팩토리얼 계산할 수 없습니다. 입력하신 값은 " + i + "입니다.");
		} else {
			for (i = i; 1 <= i; i--) {
				rs = rs * i;
				System.out.println(i);
			}//end for

			System.out.println("값=" + rs);
		}//end if/else
	}

}
