package p2021_12_31;

class StaticTest3{
  private static int a=10;		//정적 필드
  private int b=20;				//인스턴스 필드
  
  public static void printA(){    //정적 메소드에서는 this를 사용하지 못함
    System.out.println(a);         
//    System.out.println(this.a);  //컴파일 에러 발생
//    System.out.println(b);      에러 발생 //정적 메소드 안에는 정적 필드만 사용할 수 있다.
  }

  public void printB(){        //this는 인스턴스 메서드에서 여러 객체에 의해서 
    System.out.println(b); //메서드가 호출될 때 이를 구분하기 위해서 사용된다. 
    System.out.println(a); //인반 메소드는 정적필드를 쓸 수있다. StaticTest3.a인데 같은 클래스라서 생략된것.
  
  }                           
}
public class StaticTest03 {
  public static void main(String[] args) {
    StaticTest3.printA();  				//10   다른 클래스이기 때문에 정적 메소드를 불러오려면 클래스이름.메소드를 붙여야함
    StaticTest3 s1 = new StaticTest3();
    StaticTest3 s2 = new StaticTest3();
    s1.printB();
    s2.printB();
  }    
}     