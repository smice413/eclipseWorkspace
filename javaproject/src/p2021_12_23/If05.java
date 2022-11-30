package p2021_12_23;

import java.util.Scanner;

public class If05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// 키보드로 입력한 점수가 어느 학점에 해당되는지 판별하는 프로그램 작성하시오.

// 90점 이상 A학점		
// 80점 이상 B학점		
// 70점 이상 C학점		
// 60점 이상 D학점		
// 60점 미만 F학점		

		System.out.println("0~100점 사이의 정수를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt(); //s=95점일때 A학점 메세지만 출력된다. 
		                      //위의 조건이 실행 안되면 바로 아래 조건만 만족 되지만 
							  //위에서 만족되면 아래 조건은 실행 안됨
							  //즉, 하나의 조건문만 실행된다.
		if (s >= 90) {
			System.out.println("A학점");
		} else if (s >= 80) {
			System.out.println("B학점");
		} else if (s >= 70) {
		    System.out.println("C학점");
		} else if (s >= 60 ) {
			System.out.println("D학점");
		} else {
			System.out.println("F학점");
		}

		
		
	}

}
