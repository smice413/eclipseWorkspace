package p2022_01_12;

//Thread: 1개의 process를 구성하는 작업단위(동시에 이루어지는 작업을 하기 위해 사용한다.)
//Thread를 만드는 방법
// 1. Thread 클래스를 상속 받아서 만드는 방법(클래스의 단일상속만 가능)
// 2. Runnable 인터페이스를 상속 받아서 만드는 방법(클래스의 다중상속 가능)

//Thread가 두개 들어간 멀티스레드(run()로 하는 스래드와 메인메소드에서 만든 스레드)
//*하나의 메인메소드는 스레드 클래스와 상관없이 하나의 스레드로 인식하면된다. 즉, 메인메소드의 기본 생성된 스레드를 제외하고 더 스레드를 만들어야 할때 Thread클래스나 Runnable인터페이스 사용하는 것.
//---->실행할 때마다 두개의 스레드가 경쟁하며 값을 나타낸다.동시에 하는 것 같지만 실제로는 짧은 시간동안 번갈아 가면서 실행되는 것이다.
public class ThreadEnd extends Thread {

//	public void run() {
//	
	@Override
	public void run() {// 실행 중인 상태(Running 상태) //run() : Thread 클래스 안에 있는 메소드
		// TODO Auto-generated method stub
		// thread가 시작되면 실행되는 문장
		for (int i = 1; i <= 20; i++) {
			System.out.println("run number = " + i);
		}
	}
	

	public static void main(String[] args) {
		ThreadEnd tt = new ThreadEnd();
		// thread를 실행시킴
		tt.start();		//실행 가능한 상태(Runnable 상태): 오버라이딩된 run() 메소드를 호출함. run()메소드는 직접 실행 못함. start()로 실행할 수 있음.

		// main()내에서 화면에 101부터 120까지 출력
		for (int i = 101; i <= 120; i++) {
			System.out.println("-------> main number = " + i);
		}
	}

}
