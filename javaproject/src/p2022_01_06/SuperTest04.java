package p2022_01_06;

class Point2D04{							//부모 클래스
  protected int x=10; //은닉 변수
  protected int y=20; //혹은 쉐도우 변수 
}
class Point3D04 extends Point2D04{			//자식 클래스
  protected int x=40; //슈퍼 클래스에 존재하는 멤버변수를 
  protected int y=50; //서브 클래스에 다시 한 번 정의함

  protected int z=30;
  public void print( ){
    System.out.println(  x  +", "+y+", "+z);   //x와 y는 재 정의된 Point3D04 클래스 소속
  }
//super : 부모 클래스를 의미하는 레퍼런스 변수
//super.은 반드시 자식클래스의 메소드 안에서 써야한다. 단순히 자식클래스 안에서만 쓰면 오류발생.
//super. : 부모 클래스에 있는 은닉된 멤버변수와 메소드를 호출할 때 사용.  
  public void print02( ){
    System.out.println(super.x+", "+super.y+", "+z); //Point2D04 클래스 소속 멤버변수로 접근. super.x를 써서 은닉된 부모클래스 변수 x를 호출
  }						
}
class SuperTest04{
  public static void main(String[] args){
    Point3D04 pt=new Point3D04( );
    pt.print( );   //40, 50, 30 // Point3D04의 x, y
    pt.print02( ); //10, 20, 30 // Point2D04의 x, y
  }
}              