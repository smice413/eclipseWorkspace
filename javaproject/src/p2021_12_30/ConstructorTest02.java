package p2021_12_30;

class MyDate{   
  private int year;    //필드, 멤버변수 //private 접근제어자는 외부class의 접근 못하게함. 즉, 자기 class에서만 접근 가능
  private int month;   //d 주소값을 통해서 직접적인 접근 불가능. 따라서 print()메소드를 통해 접근하는 방법을 쓸 수 있음.대신 필드값을 그대로 써야함 
  private int day;

  public  MyDate(){		//기본 생성자(Default Constructure)
    System.out.println("[생성자] : 객체가 생성될 때 자동 호출됩니다.");
  }  
  public void print(){	//메소드(method)
	System.out.println(year+ "/" +month+ "/" +day); 
  }
}// MyDate end

public class ConstructorTest02 {     
  public static void main(String[] args) {
    MyDate d =  new MyDate();	
    d.print();
    
//	System.out.println(d.year); -->private이기 때문에 다른 클래스인 이곳에서 출력불가능. 따라서 메소드를 거쳐서 출력함.
//	MyDate dd =  new MyDate();
 }
} 