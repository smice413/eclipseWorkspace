package p2022_01_07;

abstract class AbstractClass{								// 추상 클래스
	abstract void Method01();								// 추상 메소드 : 반드시 abstract를 붙여야 하고 추상 클래스 안에서만 사용가능			
	void Method02(){										// 일반 메소드
	   System.out.println("Method02:  추상클래스에서 구현");
	 }
}
//
class SubClass extends AbstractClass{

//메소드 오버라이딩한것. 추상클래스를 상속 받았으면 추상메소드를 자식 구현 클래스에서 메소드 오버라이딩을 무조건 해야함. 안하면 오류발생.	abstract는 붙이면 안됨
//	void Method01(){
//		System.out.println("Method01: 서브클래스에서 구현된 추상메소드");
//	}	

	@Override		//위와 똑같은 추상메소드 오버라이딩  @(어노테이션): 컴파일과정에서 오버라이딩이 잘 되었는가 검토함.
	void Method01() {
//		super.Method01();
		// TODO Auto-generated method stub
		System.out.println("Method01: 서브클래스에서 구현된 추상메소드");
	}	
	
}
class AbstractTest01{
	public static void main(String args[]){
		
//		AbstractClass ac = new AbstractClass(); //추상 클래스는 자체적으로 객체 생성을 할 수 없다.
		
	   SubClass obj =  new SubClass();
	   obj.Method01();			//메소드 오버라이딩된 메소드가 호출된다. 부모클래스의 메소드는 호출안됨. 호출하고 싶으면 super.을 하면됨
	   obj.Method02();	   		//상속받은 Method02()메소드가 호출된다.
	 }
}


