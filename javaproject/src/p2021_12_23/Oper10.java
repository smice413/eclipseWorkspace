package p2021_12_23;

public class Oper10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		증감 연산자
//	    ++      1씩 증가   ++a(선행 처리) // a=a+1;
//		               a++(후행 처리) // a=a+1;
//
//	    --      1씩 감소    --a(선행 처리) // a=a-1;
//		               a--(후행 처리)  // a=a-1;	
// 선행이냐 후행이냐에 따라 결과받은 변수 값이 달라질 수 있다. 초기값의 선행 후행 상관없이 ++이면 1증가 --면 1감소 하면됨

		int a = 10, b = 10, c = 10, d = 10;
		int a1, b1, c1, d1;

		a1 = ++a; // 선행 연산 즉, a변수를 먼저 처리(초기값 10+1)하고 a1 변수 결과는 나중에(변화된 a=11값의 영향을 받아 a1=11) 나옴
		b1 = b++; // 후행 연산 즉, b1변수를 먼저 처리(즉, b1은 초기값 b=10과 같음)하고 b 변수 결과는 나중에(초기값10에 +1) 나옴
		c1 = --c; // 선행 연산
		d1 = d--; // 후행 연산

		System.out.println("a1="+a1+"a="+a);//a1=11a=11
		System.out.println("b1="+b1+"b="+b);//b1=10b=11
		System.out.println("c1="+c1+"c="+c);//c1=9c=9
		System.out.println("d1="+d1+"d="+d);//d1=10d=9
		
		
		
		
		
	}

}
