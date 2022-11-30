package p2021_12_23;

import java.util.Scanner;

public class FatorialEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n, f=1;
		System.out.print("정수를 입력 하세요?");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //n=3
		
		for(int i=n; i>=1; i--){
			f = f * i;      // f *= i;
		//  3=1*3
		//  6=3*2
		//	6=6*1
		
		}
		System.out.println(n+"!="+f);	
	}

}
