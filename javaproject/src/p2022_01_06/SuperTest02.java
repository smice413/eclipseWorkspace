package p2022_01_06;

//부모 클래스 안에 있는 필드는 자식 클래스에게 상속된다.
class Point2D2{
  protected int x=10;    
  protected int y=20;
}
class Point3D2 extends Point2D2{
  protected int z=30;
  public void print( ){
    System.out.println(  x  +", "+y+", "+z);   //x와 y는 상속 받아 사용하는 멤버변수 
  }
}

class SuperTest02{
  public static void main(String[] args){
    Point3D2 pt=new Point3D2( );
    pt.print( );
    
    System.out.println(pt.x);
    System.out.println(pt.y);
    System.out.println(pt.z);
  }
}               