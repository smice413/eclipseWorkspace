package p2022_01_10;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class YearCheck {

	public static void main(String[] args) {
		System.out.print("연도를 입력 하세요?");
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
//		1. 업캐스팅이 되면 부모 클래스에서 상속해준 메소드만 접근 할 수 있다.
//		2. isLeapYear()메소드는 Calendar클래스에서 상속해준 메소드가아니기 때문에 사용할 수 없다.		
//		Calendar y = new GregorianCalendar(); 오류발생
		GregorianCalendar y = new GregorianCalendar();

		if (y.isLeapYear(year)) {
			System.out.println(year + "은 윤년입니다");
		} else {
			System.out.println(year + "은 평년입니다");
		}

	}

}
