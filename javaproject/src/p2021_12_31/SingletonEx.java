package p2021_12_31;

//p244

class Singleton{
	
// 싱글톤(Singleton): 객체 생성을 1번만 수행
	private static Singleton s= new Singleton();  //정적 필드 (생성자 객체 형성하듯이 작성)
	
	public static Singleton getInstance( ) {		//정적 메소드 (사용자 정의 형태의 자료형을 붙임)
		return s; 	//위의 s를 공유한것	
	}
	
	public void check() {
		System.out.println("메소드 호출 성공1");
	}
	public void check1() {
		System.out.println("메소드 호출 성공2");
	}
	
	
}






public class SingletonEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println(Singleton.s); //s가 private라 접근이 안됨
//		Singleton st = new Singleton();
		
		Singleton obj1 = Singleton.getInstance(); //사용자 정의 클래스명이 아닌 클래스명이 자료형(ex.int느낌)으로써 앞에 온것.
		Singleton obj2 = Singleton.getInstance(); //즉, 자료형을 맞추고 메소드를 통해 호출하여 공유하는 s값을 받은것
		System.out.println(obj1); //같은 주소값이 출력되었다. 공유하고 있기 때문
		System.out.println(obj2);
		
		if(obj1 == obj2) {
			System.out.println("같은 주소");
		}else {
			System.out.println("다른 주소");
		}
		obj1.check(); //따로 생성자 객체를 형성하지 않아도 위의 obj1이 주소값을 공유 받기 때문에 
		obj1.check1();//class Singleton의 메소드를 호출받을 수 있다.
		obj2.check();
		obj2.check1();
		
		
	}

}
