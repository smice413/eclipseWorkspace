package p2022_01_10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Collections01 {
  public static void main(String[] args) {
	  
//	  Set s = Set(); Set 인터페이스는 자체적으로 객체 생성X
	  //.length: 배열의 크기 //.length(): 문자열의 길이 //.size():요소의 갯수
	  
    Set set = new HashSet();					//업캐스팅 상속받은 것만 쓸 수 있다.
//	HashSet	set = new HashSet();				//상속받은 것과 본인것 모두 쓸 수 있는 객체 생성
	System.out.println("요소의 갯수->"+set.size());
	set.add(new String("하나"));	
    set.add(2);
	set.add(3.42);
	set.add("넷");
	set.add("five");
	set.add(6);	
	set.add(6);
	System.out.println("요소의 갯수->"+set.size());	//6 //set데이터는 중복된 데이터 저장X
	System.out.println(set);//입력한 순서와 상관없이 자유분방하게 출력됨.
//Iterator(반복자) : 하나, 2, 3.42, 넷, five, 6
	Iterator elements=set.iterator();    
	while(elements.hasNext()) {//hasNext는 결과를 boolean형으로 나타낸다.가져올 값이 있으면 true로 실행문을 실행하고 없으면 false여서 멈춤.
      System.out.println("\t\t" + elements.next());
	}


/*  Vector에만 적용
	Enumeration enu = set.elements();
	while( enu.hasMoreElements()){
		System.out.println( enu.nextElement() );
	}
*/	
  }    
}                                                                                           
