package p2021_12_31;

public class UseNoneObject {

    public static void main( String[] args ) {
    									//이건 사용자 정의 클래스로 만들어서 생성자가 없더라도 객체 생성이 가능하지만
    									//Math 클래스는 구조가 정해져있는 것으로 생성자 호출이 불가능하다.
    NoneObject no = new NoneObject();	//new 연산자로 생성자 객체를 만들어도 되지만 static에서는 비효율적이다.
    System.out.println("no.number = " + no.number);
    no.printNumber();
    
    System.out.println("NoneObject.number = " + NoneObject.number);
    NoneObject.printNumber();
    
    }
}    