package p2022_01_04;

// p512
// valueof() : 기본 자료형을 문자열로 변환
//     			ex) 20       ---> "20"
//				    3.14     ---> "3.14"
//					true 	 ---> "true"

public class ValueOfEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = String.valueOf(20);   //20 ---> "20" valueof() static이 붙은 정적 메소드 이기 때문에 "."으로 호출가능
		String str2 = String.valueOf(3.14); //3.14 ---> "3.14"
		String str3 = String.valueOf(true); //true ---> "true"
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		
		
	}

}
