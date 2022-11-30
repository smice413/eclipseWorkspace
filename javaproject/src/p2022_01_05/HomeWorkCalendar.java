package p2022_01_05;

import java.util.Calendar;

public class HomeWorkCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar c = Calendar.getInstance();
		
		int h1 = c.get(Calendar.HOUR);			//12시간
		int h2 = c.get(Calendar.HOUR_OF_DAY);	//24시간
		
		int ap = c.get(Calendar.AM_PM);			//0: 오전, 1: 오후
		if(ap == 0) {
			System.out.print("오전");
		}else {
			System.out.print("오후");
		}
		System.out.println();
		
		int mm = c.get(Calendar.MINUTE);		//분
		int s = c.get(Calendar.SECOND);			//초
		int w = c.get(Calendar.DAY_OF_WEEK);	//요일: 1~7 숫자로 표시됨
		
		String[] wn = new String[] {"일","월","화","수","목","금","토"}; 
		
		System.out.println(h1+":"+mm+":"+s+":"+wn[w-1]+"요일");	//12시간
		System.out.println(h2+":"+mm+":"+s+":"+wn[w-1]+"요일");	//24시간
		
		
		
	}

}
