package p2021_12_30;

class MyDate06{   
  private int year;    
  private int month;    
  private int day;
 

//  public MyDate06(){//default 생성자
//  }  
//  public MyDate06(int new_year, int new_month, int new_day){
//    year=new_year;  // 2007
//	month=new_month;  // 7  
//	day=new_day; // 19
//  }
  public MyDate06(int year, int month, int day) {
	  this.year = year;
	  this.month = month;
	  this.day = day;
  }
  
  
public int getYear() {					//getters method
	return year;  //int형이기 때문에 return 값; 해야한다.
}


public int getMonth() {
	return month;
}


public int getDay() {
	return day;
}


public void setYear(int year) {			//setters method
	this.year = year;
}


public void setMonth(int month) {
	this.month = month;
}


public void setDay(int day) {
	this.day = day;
}


//  public void SetYear(int year){
//   // this.year=year; 
//       year=year; //매개변수로 전달된 값이 필드에 전달 되지 않는다.
//  }
//  public void SetMonth(int new_month){
//	month=new_month; // month=8
// }
  public void print(){
	System.out.println(year+ "/" +month+ "/" +day); 
  }
}
public class ConstructorTest06 {     
  public static void main(String[] args) {	
    MyDate06 d=new MyDate06(2017, 7, 19);
    d.print();               
    //d.year = 2018 은 안됨 private class이기 때문
    //d.SetYear(2018);   //변경되지 않음 (필드명과 매개변수 명이 같기 때문)
    d.setYear(2021); //특정 하나의 값씩 변경하는 법. 2021만 변경되고 월,일은 초기값 그대로이다.
    d.print();        
    //d.SetMonth(8);    //변경됨 
    d.setMonth(12);
    d.print();   
    d.setDay(30);
    d.print();
    
//    System.out.println(d.getYear()); //코드 중 가장 마지막에 할당된 값을 리턴하여 출력. 즉, 가장마지막에 setYear(2021)이 할당되었기 때문.
//    System.out.println(d.getMonth());
//    System.out.println(d.getDay());
//    
    
  }
}     