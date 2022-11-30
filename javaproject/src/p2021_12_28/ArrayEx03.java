package p2021_12_28;

import java.util.Scanner;

public class ArrayEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//키보드로 5과목의 점수를 입력 받아서, 총점과 평균을 구하는 프로그램을 작성하세요?
//배열을 쓰기전 Oper07에서 직접 변수 작성한것과 비교해봐라~
		
		int[] s = new int[5];
		System.out.println("5과목의 점수를 입력하세요?");
		Scanner sc = new Scanner(System.in);
		
		int sum=0;
		for(int i=0; i<s.length; i++) {
			s[i] = sc.nextInt();					//s[0]~s[4]까지의 방에 각각 입력점수가 들어감
			sum += s[i];							//sum=sum+s[i];
		}
		double avg = (double)sum/ 5.0;
		System.out.println("총점:"+sum);
		System.out.println("평균:"+avg);
		
		
		
		
		
		
	}

}
