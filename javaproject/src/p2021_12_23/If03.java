package p2021_12_23;

import java.util.Scanner;

public class If03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		  if(조건식){
//		         조건식이 참인경우 실행될 문장;
//		   }else{
//		         조건식이 거짓인경우 실행될 문장;
//		   }
//키보드로 정수 2개를 입력 받았을때, 최대값과 최소값을 구하는 프로그램을 작성하여라.
		
		int n1, n2, max, min;
		System.out.println("정수 2개를 입력하세요?"); 
		Scanner sc = new Scanner(System.in);
		
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		
		if(n1>n2) {
			max = n1;
			min = n2;
		}else {
			max = n2;
			min = n1;
		}
				System.out.println("max="+max);
				System.out.println("min="+min);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
