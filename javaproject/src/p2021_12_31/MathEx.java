package p2021_12_31;


public class MathEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// Math 클래스
// Math 클래스 = 정적 필드 + 정적 메소드	 즉, 생성자X(생성자 호출하면 오류 발생)	
		
//		Math m = new Math(); //오류 발생
		System.out.println("E="+ Math.E);		//로그값
		System.out.println("E="+ Math.PI);		//파이값
		
		System.out.println("abs()="+Math.abs(-10));		 //절대값
		System.out.println("ceil()="+Math.ceil(3.14));   //올림기능
		System.out.println("round()="+Math.round(10.5)); //반올림
		System.out.println("floor()="+Math.floor(10.9)); //내림기능	
		System.out.println("max()="+Math.max(10, 20));	 //최대값 기능	
		System.out.println("min()="+Math.min(10, 20));	 //최소값 기능
		System.out.println("pow()="+Math.pow(2, 3));	//2의 3승을 구하라.double형이기 때문에 int형을 넣어도 결과를 double형으로 돌려줌
		System.out.println("random()="+Math.random()); 	//0.0<random<1.0의 난수 발생기능
		System.out.println("sqrt()="+Math.sqrt(5));		//제곱근, 루트5구하라
		
		
		
		
	}

}
