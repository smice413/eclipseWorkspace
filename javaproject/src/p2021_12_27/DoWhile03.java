package p2021_12_27;

import java.util.Scanner;

public class DoWhile03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("메세지를 입력 하세요?");
		System.out.println("프로그램을 종료 하려면 q를 입력하세요?");
		
		Scanner sc = new Scanner(System.in);
		String input;
		
		do {
			System.out.println(">");
			input = sc.nextLine(); //.nextLine()은 입력한 1줄을 입력 받는다.//.next()메소드는 띄어쓰기 뒤로 다 삭제됨
			System.out.println("입력 문자:"+input);
			
		}while(!input.equals("q")); //input변수에 저장된 값이 q가 아니면 true
									//사용자가 q를 입력하면 조건식이 false가 되어서 반복문을 빠져 나온다.
		System.out.println("프로그램 종료");
		sc.close();
		
		
		
		
	}

}
