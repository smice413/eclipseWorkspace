import java.util.Calendar;

public class a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		
		int w = c.get(Calendar.DAY_OF_WEEK);	//요일: 1~7 숫자로 표시됨
		String[] wn = new String[] {"일","월","화","수","목","금","토"}; 
		System.out.println(wn[w-1]+"요일");
	
	
	
	
	
	}

}
