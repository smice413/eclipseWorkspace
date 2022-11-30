package p2022_01_07;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class HomeWork2022_01_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("해당 년도를 입력하세요?");
		Scanner sc = new Scanner(System.in);
		
		int year = sc.nextInt();
		
		if(year%4 == 0 && year%100 != 0 || year%400 == 0 ) {
			System.out.println(year+"년은 윤년입니다.");
		}else {
			System.out.println(year+"년은 평년입니다.");
		}
		
		
	}

}
