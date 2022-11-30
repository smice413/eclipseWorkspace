package p2022_01_06;

class Point2D4{			  //부모 클래스
  protected int x=10;     //  private int x=10;		private는 자식이더라도 상속 못 받음.
  protected int y=20;	  //  private int y=20;
}
class Point3D4 extends Point2D4{	//자식 클래스
  protected int z=30;
  public void print( ){
    System.out.println(  x  +","+ y +","+z);   
  }
}

class SuperSub04{
  public static void main(String[] args){
    Point3D4 pt=new Point3D4( );
    pt.print( );
  }
}