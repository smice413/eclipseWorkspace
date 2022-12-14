package p2022_01_07;

interface IHello06 {								//인터페이스
	int a = 10;										//상수: public static final 생략되어 있음.

	public abstract void sayHello(String name);		//추상메소드
}

interface IGoodBye06 {								//인터페이스
	public abstract void sayGoodBye(String name);	//추상메소드
}
//인터페이스 끼리 상속 받는 것은 extends로 해야함. 다중 상속은 허용됨.
interface ITotal06 extends IHello06, IGoodBye06 {	
	public abstract void greeting(String name);		//추상메소드
}								//인터페이스 안에서 메소드 오버라이딩을 못함. 오류발생(일반메소드가 되기 때문)

class SubClass06 implements ITotal06 {		//최종 상속받은 구현 클래스에서 메소드 오버라이딩을 모두해야함. 
	public void sayHello(String name) {			//메소드 오버라이딩
		System.out.println(name + "씨 안녕하세요!");
	}

	public void sayGoodBye(String name) {		//메소드 오버라이딩
		System.out.println(name + "씨 안녕가세요!");
	}

	public void greeting(String name) {			//메소드 오버라이딩
		System.out.println(name + ", 안녕!");
	}
}

class AbstractTest06 {
	public static void main(String[] args) {
		SubClass06 test = new SubClass06();
		test.sayHello("홍길동");				//메소드 오버라이딩된 메소드를 호출
		test.sayGoodBye("이순신");			//메소드 오버라이딩된 메소드를 호출
		test.greeting("자바");				//메소드 오버라이딩된 메소드를 호출
		
		System.out.println(IHello06.a);     //10 static이 붙어 있기 때문에 실행가능.
		
//		IHello06.a = 30;					//a는 상수이기 때문에 값 수정X
	}
}