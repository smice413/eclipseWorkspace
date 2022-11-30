package p2021_12_27;

public class Fo03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1~100 홀수의 합과 짝수의 합을 구하는 프로그램을 작성하세요?

		int odd = 0, even = 0;

		// 홀수의 합
		for (int i = 1; i <= 100; i = i + 2) {
			odd += i;
		}

		// 짝수의 합
		for (int i = 0; i <= 100; i = i + 2) {
			even += i;
		}
		System.out.println("1~100 홀수의 합="+odd);
		System.out.println("1~100 짝수의 합="+even);
		//for문을 넘어가면 지역변수는 메모리 상에서 자동으로 지워지기 때문에 i라는 변수를 똑같이 쓰더라도 오류X
		
		
	}

}
