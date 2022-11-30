package p2021_12_30;

class MyDate10{   

  private int year;    
  private int month;    
  private int day;
// 생성자 오버로딩(overloading) : 1개의 class안에 생성자 여러개 정의하는 것.
  
// this() : 같은 클래스 안에 있는 생성자를 호출할 때만 사용가능.
// 방법: 매개 변수의 자료명을 다르게 하는 것, 매개변수의 갯수를 다르게 하는 것, 매개변수의 순서로 구분.
  public MyDate10(){
    this(2006, 1, 1);                   
  }  
  public MyDate10(int new_year){
    this(new_year, 1, 1);                
  }  
  public MyDate10(int new_year, int new_month){
     this(new_year, new_month, 1);    
  }  
  public MyDate10(int new_year,int new_month,int new_day){
    year=new_year;
    month=new_month;
    day=new_day;
  }    

  public void print(){
	System.out.println(year+ "/" +month+ "/" +day); 
  }
}

public class ConstructorTest10 {     
  public static void main(String[] args) {
    MyDate10 d=new MyDate10(2007, 7, 19);  
    d.print();
    MyDate10 d2=new MyDate10(2007, 7);     
    d2.print();
    MyDate10 d3=new MyDate10(2007); //매개변수가 1개인 생성자가 호출되면, 생성자의 1,1은 매개변수 3개인 생성자를 호출하여 값을 전달하고 그 값으로 초기화됨
    d3.print();
    MyDate10 d4=new MyDate10();   //기본 생성자가 호출되면 매개변수가 3개인 생성자를 호출하여 기본생성자가 가지고 있는 값 전달하여 초기화됨       
    d4.print();
  }
}