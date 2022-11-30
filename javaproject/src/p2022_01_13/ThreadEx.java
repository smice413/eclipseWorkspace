package p2022_01_13;


import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadEx implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		SimpleDateFormat sf = 
			new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss EEE요일");
		
		while(true){
			try{
				Date d = new Date();
				System.out.println(sf.format(d));
				Thread.sleep(1000);// 1초 동안 block상태로 빠짐.
			}catch(Exception e){				
			}			
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadEx tx = new ThreadEx();
		Thread t = new Thread(tx); //Runnable에서 상속받으면 자식객체 생성 말고도 + Thread 객체를 따로 만들어야함.
		t.start();
	}

}
