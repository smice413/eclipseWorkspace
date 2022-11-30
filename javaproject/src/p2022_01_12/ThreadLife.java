package p2022_01_12;

public class ThreadLife implements Runnable{
    
    public void run() {	//실행 중인 상태(running 상태)
		for( int i=1 ; i<21 ; i++ ) {
			// thread의 이름과 정수 출력
	  System.out.println( Thread.currentThread().getName() +
										" number = " + i );
		}
    }

    public static void main( String[] args ) {	
		ThreadLife tl = new ThreadLife();

		// 첫 번째 Thread 생성
		Thread first = new Thread( tl, "first1" );
		// 두 번째 Thread 생성
		Thread second = new Thread( tl, "second1" );
		// 세 번째 Thread 생성
		Thread third = new Thread( tl, "third1" );
		
		second.start();	//실행 가능한 상태(runnable 상태. 즉, 준비상태)
		first.start();
		third.start();
    }//3개의 스레드가 하나씩 러닝상태로 들어가서 실행하다가 한번 실행이 끝난건 블락상태로 빠졌다가 다시 러닝되고 해서 모든 값이 다나오면 데드(종료)상태로 된다. 
}

