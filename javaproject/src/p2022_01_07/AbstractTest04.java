package p2022_01_07;

interface IHello04{									//인터페이스
  public abstract void sayHello(String name);		//추상메소드 : public abstract 생략 가능
}
abstract class GoodBye04{							//추상클래스
  public abstract void sayGoodBye(String name);		//추상메소드 : public abstract 생략 불가능
}


//(추상)클래스를 먼저 상속받고 인터페이스를 두번째로 상속받음. 순서가 바뀌면 오류발생
class SubClass04 extends GoodBye04 implements IHello04{
  public void sayHello(String name){				//메소드 오버라이딩
    System.out.println(name+"씨 안녕하세요!");
  }
  public void sayGoodBye(String name){				//메소드 오버라이딩
    System.out.println(name+"씨 안녕히 가세요!");
  }
}
class AbstractTest04{
  public static void main(String[] args) {
    SubClass04 test= new SubClass04();
    test.sayHello("홍길동");			//메소드 오버라이딩된 메소드가 호출됨
    test.sayGoodBye("이순신");		//메소드 오버라이딩된 메소드가 호출됨
  }   
}                          