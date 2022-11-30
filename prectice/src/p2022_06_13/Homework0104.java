package p2022_06_13;

import java.util.Scanner;

public class Homework0104 {
//	과제.
//    1. 키보드를 통해서 주민번호를 입력 했을때 유효한 
//       주민번호 인지 아닌지를 판별하는 프로그램을 작성 
//       하세요?
//       (단, 유효하지 않은 주민번호의 경우에는 메시지를 출력)
//   
//    1. 주민번호 앞자리 6자리가 아니면 메시지 출력
//    2. 주민번호 뒷자리 7자리가 아니면 메시지 출력
//    3. 유효한 주민번호 아니면 메시지 출력
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("주민번호 앞자리를 입력해주세요");

		String jm1 = sc.next();

		if (jm1.length() != 6) {
			System.out.println("주민번호 앞자리는 6자리 입니다. 다시 입력해주세요");
			jm1 = sc.next();
		}

		System.out.println("주민번호 뒷자리를 입력해주세요");

		String jm2 = sc.next();

		if (jm2.length() != 7) {
			System.out.println("주민번호 뒷자리는 7자리 입니다. 다시 입력해주세요");
			jm2 = sc.next();

		}

		String jmtotal = jm1 + jm2;
		
		if(checked(jmtotal)) {
			System.out.println("유효한 주민번호 입니다.");
		}else {
			System.out.println("올바르지 못한 주민번호 입니다.");
		}
		
	}

	
	public static boolean checked(String jmtotal) {

		int[] check = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };
		int total = 0;
		for (int i = 0; i < check.length; i++) {
			int jumintotal = check[i] * Integer.parseInt(jmtotal.substring(i, i + 1));
			total += jumintotal;
		}
		int na = total % 11;
		int ben = 11 - na;
		if (ben >= 10) {
			int ben1 = ben % 10;
			if (ben1 == Integer.parseInt(jmtotal.substring(12, 13))) {
				return true;
			} else {
				return false;
			}
		}
		
		if (ben == Integer.parseInt(jmtotal.substring(12, 13))) {
			return true;
		}else {
			return false;
		}
		
		
	}
}
