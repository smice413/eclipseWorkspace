package p2022_01_04;

import java.util.Scanner;

public class JuminCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// 키보드로 주민번호를 입력 받아서 남자인지, 여자인지를 판별하는 프로그램 작성하세요?
// 단, 주민번호 앞자리는 6자리, 뒷자리는 7자리 인지를 유효성 검사를 한다.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("주민번호 앞자리를 입력 하세요?");
		String jumin1 = sc.nextLine();				//String jumin1="900101";
		System.out.println("주민번호 뒷자리를 입력 하세요?");
		String jumin2 = sc.nextLine();				//String jumin2="1234567";
		
		String g = jumin2.substring(0, 1);			//첫번째 문자 추출
		
		if(jumin1.equals("")) {
			System.out.println("주민번호 앞자리를 입력 하세요.");
		}else if(jumin1.length() !=6){
			System.out.println("주민번호 앞자리 6자리를 입력 하세요.");
		}else if(jumin2.equals("")) {
			System.out.println("주민번호 뒷자리를 입력 하세요.");
		}else if(jumin2.length() !=7) {
			System.out.println("주민번호 뒷자리 7자리를 입력 하세요.");
		}else if(g.equals("1") || g.equals("3")) {
			System.out.println("남자 입니다.");
		}else if(g.equals("2") || g.equals("4")) {
			System.out.println("여자 입니다.");
		}else {
			System.out.println("똑바로 입력 하세요.");
		}
		
		
		
		
		
		
	}

}
