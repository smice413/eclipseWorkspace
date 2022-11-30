package p2022_01_07;

 interface IHello05{
  public abstract void sayHello(String name);
}
interface IGoodBye05{
  public abstract void sayGoodBye(String name);
}
//두 인터페이스로부터 상속을 받는 클래스 설계
class SubClass05 implements IHello05, IGoodBye05{
  public void sayHello(String name){
     System.out.println(name+"씨 안녕하세요!");
  }
  public void sayGoodBye(String name){
     System.out.println(name+"씨 안녕히 가세요!");
  }
}
class AbstractTest05{
  public static void main(String[] args) {
    SubClass05 test= new SubClass05();
    test.sayHello(args[0]);
    test.sayGoodBye(args[0]);
  }   
}         