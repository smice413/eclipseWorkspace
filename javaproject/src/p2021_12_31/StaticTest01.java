package p2021_12_31;

class StaticTest {
	static int a = 10;		//정적 필드(static영역에 저장)
	int b = 20;				//인스턴스 필드(정적 필드와 비교하기 위해 heap에 저장되는 일반 필드를 의미함)
}

class StaticTest01 {
	public static void main(String[] args) {
		System.out.println("StaticTest.a->" + StaticTest.a);
		StaticTest s1 = new StaticTest();
		StaticTest s2 = new StaticTest();

		System.out.println("s1.a->" + s1.a + "\t  s2.a->" + s2.a);
		System.out.println("s1.b->" + s1.b + "\t  s2.b->" + s2.b);

		s1.a = 100;
		System.out.print("s1.a->" + s1.a);
		System.out.println("\t  s2.a->" + s2.a + "  ");
		System.out.println(StaticTest.a);

		s1.b = 200;
		System.out.print("s1.b->" + s1.b);
		System.out.println("\t  s2.b->" + s2.b);
	}
}