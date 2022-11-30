package p2022_01_06;

//상속에서의 생성자
//1. 생성자는 상속이 되지 않는다.
//2. 자식 클래스의 생성자(기본 생성자, 매개변수가 있는 생성자)가 호출되면, 부모 클래스의 기본 생성자만 자동으로 호출됨. 
//   부모클래스의 매개변수가 있는 생성자는 super()써야함.

class Point2D05{								//부모 클래스				
  protected int x=10;
  protected int y=20;
  public Point2D05( ){							//기본 생성자
    System.out.println("슈퍼 클래스인 Point2D 생성자 호출");
  }
}
class Point3D05 extends Point2D05{				//자식 클래스	
  protected int z=30;
  public void print( ){
    System.out.println(x+", "+y+","+z);
  }
  public Point3D05( ){							//기본 생성자
    System.out.println("서브 클래스인 Point3D 생성자 호출");
  }
}

class SuperTest05{
  public static void main(String[] args){
    Point3D05 pt=new Point3D05( );
//    				   생성자 호출			//자식 클래스의 생성자를 호출하면 연쇄적으로 부모클래스의 기본 생성자도 실행된다.
    									//그리고 호출은 자식 클래스 생성자가 먼저 받지만 부모클래스 기본 생성자가 먼저 출력됨.
    pt.print( );
  }
}