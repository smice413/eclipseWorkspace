package p2021_12_23;

public class Oper11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// 증감 연산자 : ++, --
		
		int a=10, b=10;
		
		System.out.println("a="+a++); // 후행연산 a=10 *a=11이 안나오는 이유는 출력이 선행되기 때문
		System.out.println("a="+a);// a=11 *위의 메모리에 후행연산 된 값이 다음 출력에 반영된 것
		
		System.out.println("b="+(++b));// 선행연산 b=11
		System.out.println("b="+b); // b=11
		
	}

}
