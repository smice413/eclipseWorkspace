package p2022_01_10;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class HomeWork2022_01_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("해당 년도를 입력하세요?");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		GregorianCalendar gr = new GregorianCalendar();
		if(gr.isLeapYear(n)){
			System.out.println(n+"년은 윤년입니다.");
		}else {
			System.out.println(n+"년은 평년입니다.");
		}
		
	}

}
