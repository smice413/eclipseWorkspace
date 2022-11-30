package p2022_01_05;

public class WrapperEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// Wrapper 클래스 : Integer
		
// int형 변수의 최대값과 최소값
		System.out.println("max="+ Integer.MAX_VALUE);	//max=21억
		System.out.println("min="+ Integer.MIN_VALUE);	//min=-21억
		
//		Integer i = new Integer(); //오류 발생 : 기본 생성자를 지원하지 않기 때문
		
// 		String형을 int형으로 형변환 : "20"--->20
		int n = Integer.parseInt("20");
		System.out.println(n);			//20 숫자
		System.out.println(n+10);		//30 숫자  문자였으면 2010이 될것.
		
//		10진수를 2진수,8진수,16진수로 변환
		System.out.println("2진수:"+Integer.toBinaryString(10));		//2진수 : 1010
		System.out.println("8진수:"+Integer.toOctalString(10));		//8진수 : 12
		System.out.println("16진수:"+Integer.toHexString(10));		//16진수: a
		
		
		
	}

}
