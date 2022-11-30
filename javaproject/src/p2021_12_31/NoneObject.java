package p2021_12_31;

public class NoneObject {
    static int number = 3;					//정적 필드
    
    public static void printNumber() {		//정적 메소드
        System.out.println("number = " + number);
    }
}    //메인 메소드가 없기 때문에 메인 메소드를 만들던지, 메인 메소드를 가진 새로운 클래스를 만들던지 해야함
	//여기서는 메인메소드 있는 새로운 클래스 파일 만듬(UseNoneObject)