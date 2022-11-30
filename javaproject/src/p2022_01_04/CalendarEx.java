package p2022_01_04;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// 3. Calendar 클래스
		
//		Calendar c1 = new Calendar(); //객체 생성 못함 오류 발생
		//Calendar 객체 형성 방법1
		Calendar c2 = new GregorianCalendar();  //Calendar(부모) = new GregorianCalendar(자식)(); 
												//--> 레퍼런스 형변환 : 업캐스팅  (자식이 객체를 형성해서 부모한테 전달)  
		//Calendar 객체 형성 방법2	
		Calendar c = Calendar.getInstance();  //Calendar라는 자료형으로 c3변수 선언하고 Calendar클래스.getInstance()메소드 호출.
		System.out.println(c);					//c는 1970.01.01 기준으로 지금까지를 초단위로 표시함
		System.out.println(Calendar.YEAR);		//현재 년도가 안구해지고 1이라는 상수값이 뜸
		
		int y = c.get(Calendar.YEAR);			//get함수를 통해 현재 년도를 구해야함
		int m = c.get(Calendar.MONTH)+1;		//월(0~11)로 표시되기 때문에 +1을 해야함
		int d = c.get(Calendar.DATE); 			//일
		
		
		System.out.println(y+"-"+m+"-"+d);
		
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
