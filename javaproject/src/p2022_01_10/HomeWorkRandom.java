package p2022_01_10;

import java.util.TreeSet;

public class HomeWorkRandom {
//	1~45 사이의 정수중에서 6개의 숫자를 추출하는 
//    로또 프로그램을 작성하세요? 
//     Math.random()
//     Random 클래스 
//
//    1) Set자료구조를 사용해서 중복 숫자가 나오지 않도록 작성하세요.
//    2) 추출된 6개의 숫자를 오름차순으로 정렬해서 출력하세요.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeSet st = new TreeSet();
		while(true) {
			int num = (int)(Math.random() * 45)+1;
			st.add(num);
			if(st.size()==6) {
				System.out.println(st);
				break;
			}
		}
		
	
			
		
		
		
		
	}

}
