package p2021_12_23;

import java.util.Scanner;

public class Switch01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		 switch~case문
//
//	     switch(변수){
//	(변수에 초기 값을 부여하고 case 값1과 비교하여 적합할 때 실행O 출력O)
//		case 값1: 실행될 문장;
//			break; (보조 제어문으로 swhitch ~ case문을 완전히 빠져나감. 즉 해당 case를 만족하고 break문 기준으로 밑에 것은 출력X)
		            //break문이 없다면 해당 case를 기준으로 밑의 case까지 다 출력됨
//		case 값2: 실행될 문장;
//			break; 
//		default: 위의 case를 만족하지 않을때
//		            실행될 문장;
//	     }
		
		
		// 키보드로 입력한 점수가 어느 학점에 해당되는지 판별하는 프로그램 작성하시오.

		// 90점 이상 A학점
		// 80점 이상 B학점
		// 70점 이상 C학점
		// 60점 이상 D학점
		// 60점 미만 F학점

		System.out.println("0~100점 사이의 점수를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
        s = s/10; //int형과 int형을 산술연산 수행하면 int형으로 결과가 나옴. 즉 정수가 나옴
		
		switch (s) {//위에 s=s/10;쓰지 말고 switch(s/10)으로 해도 됨. 확장대입 연산자로 하면 s/=10;
		case 10://아래의 case와 함께 A학점을 적용받기 위해 break문X 그리고 System.out도 밑에 것으로같이 받으면됨
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		case 6:
			System.out.println("D학점");
			break;
		default:
			System.out.println("F학점");
		}

	}

}
