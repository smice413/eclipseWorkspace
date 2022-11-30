package p2021_12_23;

import java.util.Scanner;

public class If02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		  if(조건식){
//		         조건식이 참인경우 실행될 문장;
//		   }else{
//		         조건식이 거짓인경우 실행될 문장;
//		   }
// 키보드로 입력한 정수가 짝수인지, 홀수인지 판별하는 프로그램을 작성하세요?
		
		System.out.println("정수를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		if(n % 2 ==1) {//홀수 *나머지0은 짝수임
			System.out.println(n+"은(는) 홀수");
		}else {
			System.out.println(n+"은(는) 짝수");
		}

		
		
		
		
		
		
				
				
				
				
				
		
		
	}

}
