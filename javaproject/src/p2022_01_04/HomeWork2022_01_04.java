package p2022_01_04;

import java.util.Scanner;



public class HomeWork2022_01_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 1. 키보드를 통해서 주민번호를 입력 했을때 유효한 
//         주민번호 인지 아닌지를 판별하는 프로그램을 작성 
//         하세요?
//         (단, 유효하지 않은 주민번호의 경우에는 메시지를 출력)
		
		Scanner sc = new Scanner(System.in);
		System.out.println("주민번호 앞자리를 입력하세요?");
		String jm1 = sc.nextLine();
		System.out.println("주민번호 뒷자리를 입력하세요?");
		String jm2 = sc.nextLine();
		String jj = jm1+jm2;
		int sum = 0;
		
		int[] n1 = new int[] {2,3,4,5,6,7,8,9,2,3,4,5};
	
	
		
		for(int i=0; i<12; i++) {
			sum += Integer.parseInt(jj.substring(i, i+1))*n1[i];
		}
			
			
	
		
//		String a = jm1.substring(0, 1);
//		String b = jm1.substring(1, 2);
//		String c = jm1.substring(2, 3);
//		String d = jm1.substring(3, 4);
//		String e = jm1.substring(4, 5);
//		String f = jm1.substring(5, 6);
//		String g = jm1.substring(6, 7);
//		String h = jm1.substring(7, 8);
//		String i = jm1.substring(8, 9);
//		String j = jm1.substring(9, 10);
//		String k = jm1.substring(10, 11);
//		String l = jm1.substring(11, 12);
//		String m = jm1.substring(12, 13);
//		
		
		
		
		
		
		
		
	}

}
