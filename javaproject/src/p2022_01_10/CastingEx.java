package p2022_01_10;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class CastingEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		** 레퍼런스 형변환 **
//		   - 두개의 클래스 사이에 상속관계가 있어야함
//		 
//		* 업캐스팅(자동 형변환)
//		   1. 서브클래스에서 슈퍼클래스로 형변환 하는것
//		   2. 참조 가능한 영역이 축소가 된다.
//		   3. 컴파일러에 의해서 암시적 형변환(자동 형변환) 된다.
		
// ex1)	java.util.Calendar(부모 클래스)
//	      - java.util.GregorianCalendar(자식 클래스)
		
//		Calendar c = new Calendar();   			//오류발생
		
		Calendar c1 = Calendar.getInstance();		
		
        Calendar c2 = new GregorianCalendar();	//업캐스팅
        
        GregorianCalendar c3 = new GregorianCalendar();
        
        
// ex2)        
//      List 인터페이스는 자체적으로 객체를 생성할 수 없다. 추상클래스도 마찬가지
//		List li = new List();					//오류발생
		List list = new ArrayList();			//업캐스팅
		ArrayList al = new ArrayList();
		
		
// ex3)
//		add(Object e) : add() 메소드는 여러가지 자료를 저장하는 메소드. 매개변수가 Object이기 때문에 하위 클래스는 모두 올수 있다.
//		배열과 비슷하여 순차적으로 저장할 수 있고, 다른 특징으로 배열과 달리 여러가지 자료를 저장가능.
		
		list.add(10);	//Object e = new Integer(10);  박싱+업캐스팅
		list.add(3.14);//Object e = new Double(3.14);  박싱+업캐스팅
		list.add('j'); //Object e = new Character('j');박싱+업캐스팅
		list.add(true);//Object e = new Boolean(true); 박싱+업캐스팅
		list.add("자바");//Object e = new String("자바"); 박싱+업캐스팅
		
		
		
//		boolean equals(Object an)		//매개변수가 최상위 클래스 이기 때문에 다른 하위 클래스가 적용되면 업캐스팅하는 것이다.
		
//		Object an = (Object) new String("java"); 			//업캐스팅
		if("java".equals(new String("java"))) {
			System.out.println("같은 값");
		}else {
			System.out.println("다른 값");
		}
		
//		Object an = new Integer(30);						//박싱 + 업캐스팅
//		Object an = 30;										//오토박싱 + 업캐스팅
		if(new Integer(30).equals(new Integer(30))) {
			System.out.println("같은 값");
		}else {
			System.out.println("다른 값");
		}
		
//		Object an = new Double(3.15);						//박싱 + 업캐스팅
//		Object an = 3.15;									//오토박싱 + 업캐스팅
		if(new Double(3.14).equals(new Double(3.15))) {
			System.out.println("같은 값");
		}else {
			System.out.println("다른 값");	
		}
//		-----------------------------------------------------------------------------------------
//		* 다운 캐스팅(강제 형변환)
//		   1. 슈퍼클래스에서 서브클래스로 형변환 하는것
//		   2. 참조 가능한 영역이 확대가 된다.
//		   3. 컴파일러에 의해서 암시적 형변환(자동 형변환)이 되지 않기    
//		      때문에 자료형을 생략할 수 없다.(강제 형변환)

// ex1.
		List lt = new ArrayList(); 					//업캐스팅
		
// 		add(Object e)		//매개변수에 Object가 있으면 업캐스팅이됨. 밖으로 나가있으면 다운캐스팅 됨.
		lt.add(new String("자바"));	    			//업캐스팅
		lt.add("오라클");
		lt.add("JSP");
		lt.add("스프링");
		lt.add("파이썬");
		lt.add("텐스플로우");
		lt.add("케라스");
		
// 		Object get(int index)	//매개변수가 아닌 결과를 Object로 받기 때문에 하위 상속받는 String으로 저장한다. 이유는 add에 String만 있기 때문.
		for(int i=0;i<lt.size(); i++) { //.size()는 자료구조에서 활용되는 메소드.
//			Object obj = lt.get(i);
			String str = (String) lt.get(i);		//다운 캐스팅	lt.get(i)부모 클래스가 오른쪽에 있기 때문에 (String)써야함.
			System.out.println(str);
		}
		
// ex.2
		List ls = new ArrayList();    				//업캐스팅
		
//		add(Object e)
		ls.add(new Integer(10));					//박싱+업캐스팅
		ls.add(200);								//오토박싱+업캐스팅
		ls.add(3000);								//오토박싱+업캐스팅
		ls.add(40000);								//오토박싱+업캐스팅
		ls.add(500000);								//오토박싱+업캐스팅
		
//		Object get(int index)
		for(int i=0; i<ls.size(); i++) {
//			Object obj = ls.get(i);
			
			Integer it = (Integer)ls.get(i);		//다운캐스팅
			int n = it.intValue();					//언박싱
			
			int n1 = ((Integer)ls.get(i)).intValue();//다운캐스팅+언박싱
			System.out.println(n1);
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
	}

}
