package p2021_12_28;

import java.util.Scanner;

public class HomeWork2021_12_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	       키보드를 이용해서 정수 5개를 입력 받은후 int형
//	       배열에 저장한다. 이때 배열에 저장된 값중에서
//	       최대값과 최소값을 구하는 프로그램을 작성하세요?
//hint: for문을 2개 써야할 듯
		int[] s = new int[5];
		System.out.println("정수 5개를 입력하세요?");
		Scanner sc= new Scanner(System.in);
		int min=0, max=0;
			
		for (int i = 0; i < s.length; i++) {
			s[i]=sc.nextInt();
			
			if(i==0) {
				min = s[0]; max = s[0];
				
			}else if (s[i]<min) {
				min = s[i];
			}else if (s[i]>max) {
				max = s[i];
			}
		}
		System.out.println("max=" + max);
		System.out.println("min=" + min);
		
	}

}
