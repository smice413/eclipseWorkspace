package p2021_12_23;

public class If06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// if else 난수(무작위 수)에 관한 예제
		// 난수 발생 시키는 방법 2가지:
		// 1. 0.0 <= Math.random() <1.0 의 값이 무작위로 나온다.
		// 난수 = (정수화) (Math.random() * (상한값<가장 높은 값을 의미>-하한값+1)) +하한값;

		System.out.println(Math.random()); // Math.가 정적필드, random은 정적 메소드이기 때문에 따로 객체 형성하지 않고,
											// class.mathod()로 바로 불러올 수 있다.

		System.out.println(Math.E);// E(자연로그)
		System.out.println(Math.PI);// PI(원주율)

		// 주사위 번호 뽑기: 1~6
		int num = (int) (Math.random() * 6) + 1;// 1~6 *곱하기 6은 0.0에 하고 +1을 해서 정수1을 구한것
												// 그리고 5.99에 6을 곱하면 int값으로 5가 되고 +1을 해서 정수 6만듬
		// Math.random은 Double형 데이터 이기 때문에 int를 넣어 강제 형변환 시킴
		System.out.println("num=" + num);

		if (num == 1) {
			System.out.println("1번 주사위");
		} else if (num == 2) {
			System.out.println("2번 주사위");
		} else if (num == 3) {
			System.out.println("3번 주사위");
		} else if (num == 4) {
			System.out.println("4번 주사위");
		} else if (num == 5) {
			System.out.println("5번 주사위");
		} else {
			System.out.println("6번 주사위");
		}

		System.out.println("1~45사이의 난수 발생");
		int r = (int) (Math.random() * 45) + 1;
		System.out.println("난수:" + r);

		
		
	}

}
