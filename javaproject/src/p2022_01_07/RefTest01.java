package p2022_01_07;

class Parent{
  public void parentPrn( ){
     System.out.println("슈퍼 클래스 : ParentPrn 메서드");  
  }
}
class Child extends Parent{ 
  public void childPrn( ){
     System.out.println("서브 클래스 : ChildPrn 메서드");  
 }                                             
}

//** 레퍼런스 형변환 **
//- 두개의 클래스 사이에 상속관계가 있어야함
//
//* 업캐스팅(자동 형변환)
//1. 서브클래스에서 슈퍼클래스로 형변환 하는것
//2. 참조 가능한 영역이 축소가 된다.(즉, 상속받은 것만 쓸 수 있고 다른 것은 쓰지 못함)
//3. 컴파일러에 의해서 암시적 형변환(자동 형변환) 된다.

class RefTest01{
  public static void main(String[] args){
    Child c = new Child();  
     
    c.parentPrn();   	//상속받은 메소드 호출
    c.childPrn();    	//자신의 메소드 호출
    
    Parent p;       
    p=c;    //암시적으로 업 캐스팅이 일어남.//p=(Parent)c; // Parent p = new Child();
    
    p.parentPrn();     //업 캐스팅 후에는 부모로부터 상속받은 메서드만 호출할 수 있다,
//  p.childPrn();      //컴파일 에러가 발생하게 된다. 
  }                                           
}       