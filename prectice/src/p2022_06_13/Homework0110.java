package p2022_06_13;

import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.TreeSet;

public class Homework0110 {
//	과제.
//	  1. 키보드를 통해서 연도(ex) 2020)를  입력 받는다.
//	       이때 입력 받은 연도가 윤년인지 평년인지를 판별하는 
//	       프로그램을 작성하세요?
//	       (단, GregorianCalendar 클래스를 이용해서 처리 하세요.)
//
//	// 1년 365.242374
//	// 평년 = 365일 (2월달 - 28일까지)
//	// 윤년 = 366일 (2월달 - 29일까지)
//
//	  2.
//	      1~45 사이의 정수중에서 6개의 숫자를 추출하는 
//	       로또 프로그램을 작성하세요? 
//	        Math.random()
//	        Random 클래스 
//
//	       1) Set자료구조를 사용해서 중복 숫자가 나오지 않도록 작성하세요.
//	       2) 추출된 6개의 숫자를 오름차순으로 정렬해서 출력하세요.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		
//		int year = sc.nextInt();
//		
//		GregorianCalendar grec = new GregorianCalendar();
//		if(grec.isLeapYear(year)) {
//			System.out.println(year+"년은  윤년입니다.");
//		}else {
//			System.out.println(year+"년은 윤년이 아닙니다.");
//		}
		
		TreeSet set = new TreeSet();
		
		for(int i=0; i<6; i++) {
		int num = (int) (Math.random()*45)+1;
		set.add(num);
//		if(set.size() == 6) {
//			break;
//		}
		}
		System.out.println(set);
		
		
	}

}
