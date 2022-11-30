package p2021_12_30;

class MyDate04{   
  int year;    						//필드 멤버변수
  int month;    
  int day;  

  public MyDate04(){				//기본 생성자
    year=2016;    month=4;    day=1;
  }
 // this. : 내부 레퍼런스 변수. 즉 d2가 가진 주소값을 this를 통해 내부적으로 전달함.
//  public MyDate04(int year,int month,int day){
//   this.year=year; //this.을 붙이면 필드명과 매개변수명을 동일하게 쓸 수있다.
//   this.month=month;
//   this.day=day;
//  }
  public MyDate04(int year, int month, int day) {
	  this.year = year;
	  this.month = month;
	  this.day = day;
  }
  
  public void print(){
	System.out.println(year+ "/" +month+ "/" +day); 
  }
}// MyDate end

public class ConstructorTest04 {     
  public static void main(String[] args) {
    MyDate04 d=new MyDate04();	//기본생성자가 자동생성 안되기 때문에 오류발생한것.
    System.out.println(d.year);
    System.out.println(d.month);
    System.out.println(d.day);
    d.print();

    MyDate04 d2=new MyDate04(2017, 7, 19);
    System.out.println(d2.year);
    System.out.println(d2.month);
    System.out.println(d2.day);
    d2.print();
  }
}            