package p2021_12_30;

class MyDate05{   
  private int year;    //필드
  private int month;    
  private int day;
//기본생성자를 생략하면 보통 컴파일러가 자동으로 생성해서 실행되지만,
//매개변수가 있는 생성자가 더 있기 때문에 자동으로 생성이 되지 않아 생성자를 호출해도 호출안되는 오류가 발생한다.
  public MyDate05(){  //기본 생성자
  }
  //매개변수가 있는 생성자는 초기값을 설정하기 위함이다.
  public MyDate05(int new_year, int new_month, int new_day){//생성자에 필드명과 다른 이름의 매개변수가 들어감.
	  														//동일한 이름을 쓰면 값 전달이 안됨.
	  														//this.year=year 이렇게는 가능함.
    year=new_year;	//필드 초기값을 매개변수를 통해 할당받으라는 의미  //초기화된 값: 2017
    month=new_month;									//초기화된 값: 7
    day=new_day;										//초기화된 값: 19
  }  
  public void print(){	//메소드 다른 클래스로 출력을 할 수 없기 때문에 자기 클래스의 메소드를 거쳐 출력시킴
    System.out.println(year+ "/" +month+ "/" +day); 
  }
}
public class ConstructorTest05 {     
  public static void main(String[] args) {
    MyDate05 d=new MyDate05();  //위의 기본생성자를 생략하면 보통 컴파일러가 자동으로 생성해서 실행되지만,
    d.print();					//매개변수가 있는 생성자가 더 있기 때문에 자동으로 생성이 되지 않아 오류가 발생한다.

    MyDate05 d2=new MyDate05(2017, 7, 19);
    d2.print();
  }
}      