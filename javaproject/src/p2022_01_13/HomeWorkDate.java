package p2022_01_13;


import java.text.SimpleDateFormat;
//Thread를 이용해서 현재 시간(년,월,일,시,분,초,요일)을 1초에 한번씩 
//출력하는 프로그램을 작성 하세요?
import java.util.Date;

public class HomeWorkDate extends Thread {

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		SimpleDateFormat si = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss EEE요일");
		
	 while(true) {
		 Date d = new Date();
		 System.out.println(si.format(d));
		 
		 try {
			 Thread.sleep(1000);
		 }catch(Exception e) {
			 e.toString();
		 }
	 }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HomeWorkDate h = new HomeWorkDate();
		h.start();
		
		
			
			
		
		
		
	}

}
