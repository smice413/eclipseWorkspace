import  packTest.packOne.AccessTest;

//AccessTest의 서브 클래스로 SubOne을 설계
class SubOne extends AccessTest {
  void subPrn( ){
    System.out.println(a); //[1. Sub] private -X
    System.out.println(b); //[2. Sub] 기본 접근 지정자-X
    System.out.println(c); //[3. Sub] protected -O //protected는 패키지가 달라져도 상속관계에 있기 때문에 public권한을 얻게 됨
    System.out.println(d); //[4. Sub] public -0
  }
}

//AccessTest랑 상속관계가 없는 클래스 
class SuperSubA{
  public static void main(String[] args){
    AccessTest at=new AccessTest( );
    at.print( );
    System.out.println("main");
    System.out.println(at.a); //[1. main] private -X
    System.out.println(at.b); //[2. main] 기본 접근 지정자-X
    System.out.println(at.c); //[3. main] protected -X //부모 클래스와 메인메소드를 가진 클래스가 상속관계 아니기 때문에 public권한X
    System.out.println(at.d); //[4. main] public -O
  }
}