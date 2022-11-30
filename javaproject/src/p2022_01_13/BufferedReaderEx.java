package p2022_01_13;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// 키보드로 구구단 1개 단을 입력 받아서, 구구단 1개 단을 출력하는 프로그램을 작성하세요?
		System.out.println("원하는 단을 입력하세요.");
		BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
		
		
		try {
			
			String s = bu.readLine();
			int dan = Integer.parseInt(s);
			for(int i = 1; i<10; i++)
				System.out.println(dan+"*"+i+"="+(dan*i));
			
		}catch(Exception e) {
			System.out.println("숫자만 입력하세요.");
//			e.printStackTrace();
		}
			
		
	}

}
