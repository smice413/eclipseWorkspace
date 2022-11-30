package p2022_01_12;

//Runnable 인터페이스이기 때문에 implements로 상속 한다. 그리고 java.lang에 속해서 import안해도 됨
//추상메소드 run()만 가지고 있다.
//


public class RunnableTest implements Runnable {
	
    // 1부터 20까지 화면에 출력시키는 메소드 
    @Override
    public void run() {    //public붙여야 하는 메소드 오버라이딩
    	// TODO Auto-generated method stub
    	for( int i=1 ; i<=20 ; i++ ) {
			System.out.println( "number = " + i );
    }
    }
    public static void main( String[] args ) {
		// 객체 생성
		RunnableTest tt = new RunnableTest();
		// 새 Thread 클래스 객체 생성 // 생성자객체 호출방식: Thread(Runnable target);
		Thread t = new Thread( tt );
		// Thread를 시작시킴
		t.start();			//실행 가능한 상태: run()를 호출함.
		System.out.println( "--------> main thread end" );
    }

}
