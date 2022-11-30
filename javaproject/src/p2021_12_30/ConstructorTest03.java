package p2021_12_30;

class MyDate03{   
  private int year;    //필드 , 멤버변수
  private int month;    
  private int day;
  public MyDate03(){ // 기본 생성자 
    year=2016;		//생성자에 필드값을 쓰면 생성자 호출시 이 값으로 초기화 한다.
    month=4;
    day=1;
  }  
  public void print(){
	System.out.println(year+ "/" +month+ "/" +day); 
  }
}// MyDate end

public class ConstructorTest03 {     
  public static void main(String[] args) {
    MyDate03 d=new MyDate03();
    d.print(); 
  }
}               