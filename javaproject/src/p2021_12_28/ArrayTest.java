package p2021_12_28;

import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int max, min;					//변수 선언
		int[] s = new int[5];			//배열 설정. 초기값은 0으로 자동으로 초기화됨

		System.out.print("정수 5개를 입력 하세요?");
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < s.length; i++) {//0부터 4번 방까지 루프돌림
			s[i] = sc.nextInt();
		}
		max = s[0];//s변수 0번 방에 들어가있는 값을 max변수의 초기값으로 설정
		min = s[0];//s변수 0번 방에 들어가있는 값을 min변수의 초기값으로 설정
		for (int i = 1; i < s.length; i++) {
			if (max < s[i]) max = s[i];
			if (min > s[i]) min = s[i];
		}
		System.out.println("max=" + max);
		System.out.println("min=" + min);
	}

}
