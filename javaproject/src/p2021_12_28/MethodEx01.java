package p2021_12_28;

public class MethodEx01 {
	// 메소드 : 여러가지 코드를 모아 놓은 것
	// 메소드 사용이유: 코드를 재사용하기 위함.
	
//    *void나 자료형 둘중에 하나가 오는데 void는 return 값을 쓸 필요없다. 자동으로 하기 때문. 자료형은 반드시 return값 써야함
//	  *void는 값을 돌려 받지 않아도 된다는 의미. 물론 return구문 자체가 실행하기 위한 것이기 때문에 써야하는 것이지만 void는 생략해도 자동으로 됨.
//접근제어자	           void
//(접근지정자)     공유      자료형     메소드명(매개변수)
//
//public      static     void      check(){
//    
//return   값;
//}
//
//
//cf. 접근 제어자
//public, 생략(default접근제어자), private, protected
	
	
	
	//사용자 정의 메소드 위치가 중요: Java는 상관없지만, 일반적으로 다른 언어는 main method 위에 있어야함.
	//사용자 정의 메소드 
	//사용자 정의 메소드는 프로그래머가 직접 호출해야 한다. 만들어 놨다고 실행해봐야 실행안됨.
//public:접근제어자  static:정적메소드(공유)
	public static void check() {//1개의 메소드를 호출할 것이기 때문에 접근제어자 생략하여 defult접근제어자 상태도 됨.
		System.out.println("메소드 호출 성공");
		return;//void이기 때문에 return; 생략 가능함
	}
	
	// 값 전달에 의한 메소드 호출(call by value 방식): 기본 자료형을 매개 변수로 쓸 때 값을 전달하여 쓰기 때문에.
	                                        //참조형은 값이 아닌 주소값을 불러오기 때문에 다르다.
	static void check(int a) {	//매개변수(parameter) : int a =30
		                        //이 매개변수는 지역변수이기 때문에 호출할 때만 잠깐 stack메모리에 저장되었다가 끝나면 삭제됨.
		System.out.println("전달된 값:"+a);
	}

	static void check(int a, double d) {// 메소드 오버로딩: 1개의 클래스 안에 여러개의 매개 변수 쓰는것.
		double result = a+d; //double 형이 int형 보다 더 큰 데이터기 때문에 합은 double형으로 출력됨.
		System.out.println("전달된 값의 합:"+ result);
	}
	
	static void check(char c) {//char c = 'A'
		System.out.println("전달된 값:"+c);
	}
	
	static void check(boolean b) {// boolean b = true
		System.out.println("전달된 값:"+b);
	}
	// 주소값 전달에 의한 메소드 호출 방식(call by reference 방식): 매개변수가 참조형
	static void check(String s) {// String s = "자바" //String s = new String("자바")
		System.out.println("전달된 값:"+s);//s 매개변수에게 주소값을 전달하라는 의미
	}
	
	static int check01( ) { //메소드 check를 똑같이 못 쓴다.
		return 50; //return 문: 메소드를 호출한 곳에 값을 돌려 주는 역할. 메소드 가장 마지막 줄에 써라.
		                       //즉, return문 뒤에 어떤 내용도 오면 안됨.
	}
	static double check02( int a, double d) {
		double result = a+d;
		return result;
	}
	
	
	
//메인 메소드는 JVM(자바가상머신)으로 자동실행가능.즉 ctrl+f11로 했을 때 가능.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		check();//사용자 정의 메소드를 호출하려면 메인메소드에 check를 써놓아야 호출가능
		//원래는 MethodEx01.check();로 써야하는데 같은 Class안에 있기때문에 생략 가능.
		check(30); //int a=30
		check(10, 10.5);//int a= 10, d=10.5
		check('A');
		check(true);
		check("자바");
		check(new String("자바"));
		check01(); //return 문으로 돌려받은 값이 출력되지 않는다. syso가 없기 때문.
		int result = check01();
		System.out.println("돌려 받은 값1:"+result);//50을 출력 하려면 result 변수로 선언해서 받는법
		
		System.out.println("돌려 받은 값2:"+check01());//50을 바로 출력 하는 방법
		
		
		double result2= check02(50, 3.14);
		System.out.println("돌려 받은 값3:"+result2);//result2 변수 선언해서 받는 법
		
		System.out.println("돌려 받은 값4:"+check02(50, 3.14));//바로 출력 받는 법
		
		
		
	}

}
