package p2021_12_31;

class StaticTest4 {
	private static int a = 10;	//정적필드
	private int b = 20;			//인스턴스 필드

	public static void printA() {
		System.out.println(a);
//		System.out.println(b); // 컴파일 에러 발생 : 메모리 영역이 달라 정적 필드만 사용할 수 있기 때문
	}

	public void printB() {
		System.out.println(b);
	}
}

public class StaticTest04 {
	public static void main(String[] args) {
		StaticTest4.printA();
		StaticTest4 s1 = new StaticTest4();
		StaticTest4 s2 = new StaticTest4();
		s1.printB();
		s2.printB();
	}
}