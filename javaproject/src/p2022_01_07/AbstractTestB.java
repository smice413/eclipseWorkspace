package p2022_01_07;

abstract class AbstractClassB{						//추상클래스
	abstract void Method01();						//추상메소드
	void Method02(){								//일반메소드
	   System.out.println("Method02:  추상클래스에서 구현");
	 }
}
abstract class MiddleClassB extends AbstractClassB{//추상클래스가 추상클래스를 상속
	void Method01(){								          //메소드 오버라이딩 :MiddleClassB에서 해도되고 
	  System.out.println("Method01: 서브클래스에서 구현된 추상메소드"); //여기서 안했다면 최종상속 받는 클래스인 SubClassB에서 해도됨
	}
	public void Method03(){
	  System.out.println("Method03: 추상클래스에서 구현");
	}
}
class SubClassB extends MiddleClassB{
//	void Method01(){
//	  System.out.println("Method01: 서브클래스에서 구현된 추상메소드");
//	}
}
class AbstractTestB{
	public static void main(String args[]){
	   SubClassB obj =  new SubClassB();
	   obj.Method01();		//부모 클래스의 메소드 오버라이딩된 메소드를 SubClassB가 상속 받아서 사용
	   obj.Method02();		//조부모 클래스의 메소드를 SubClassB가 상속받아서 사용
	   obj.Method03();		//부모클래스의 메소드를 SubClassB가 상속받아서 사용
	 }
}


