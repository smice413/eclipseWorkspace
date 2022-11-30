package p2022_01_05;

public class WrapperEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Double d = new Double();    		//오류발생 : 기본생성자 지원X
		
		Double d1 = new Double(3.14);		//박싱
		Double d11 = 3.14;					//자동 박싱
		
		double n1 = d1.doubleValue();		//언박싱
		double n11 = d1;					//자동 언박싱
		
//		자료형 변환 : "42.195" ---> 42.195
		Double d2 = new Double("42.195");	//박싱
//		Double d22 = "42.195";				//오류 발생  Double자료형과 String자료형이 상속관계가 아니기 때문에 자동형변환으로 자동 박싱X
		
		double n2 = d2.doubleValue();		//언박싱
		double n22 = d2;					//자동 언박싱   언박싱하면서 자료형변환 일어남.
		
//		자료형 변환 : "42.195" ---> 42.195
		double num = Double.parseDouble("42.195");   //integer.parseint("");와 같음
		System.out.println(num);
		
		
		
	}

}
