package p2021_12_23;

import java.util.Scanner;

public class Oper07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// 논리 연산자 : and(&&), or(||), not(!), xor(^)

// 5과목의 점수를 키보드로 입력 받았을 때, 입력한 점수로 합격, 불합격을 판별하는
// 프로그램을 작성하세요? 단, 과목당 과락은 40점이고, 평균 60점 이상 받아야 합격한다.
		int n1, n2, n3, n4, n5, total;
		double avg;
		System.out.println("5과목의 점수를 입력 하세요?");
		Scanner sc = new Scanner(System.in);

		n1 = sc.nextInt();
		n2 = sc.nextInt();
		n3 = sc.nextInt();
		n4 = sc.nextInt();
		n5 = sc.nextInt();

		total = n1 + n2 + n3 + n4 + n5; // 총점
		avg = total / 5;                // 평균 *평균값은  소수점 자리가 무조건 0으로 나옴
		// 이유는: 좌변이 double형 데이터, 우변이 int형 이기 때문 따라서 int형에서 이미 실수로 못 나타내기 때문에 더블형으로
		// 자동형변환 되더라도 소수점이 0으로 나오는 것. 따라서 우변을 double형으로 강제 형변환 시키거나, 5를 5.0으로 표시하면 됨
		
		System.out.println("avg:"+avg);
		
		if(n1>=40 && n2>=40 && n3>=40 && n4>=40 && n5>=40 && avg>=60) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
		

	}

}
