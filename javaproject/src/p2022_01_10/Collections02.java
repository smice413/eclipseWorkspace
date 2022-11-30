package p2022_01_10;

import java.util.ArrayList;

class Collections02 {

  public static void main(String[] args) {
	  
//	  List li = new List(); //인터페이스 이기 때문에 자체적으로 객체 생성X
	  
	  
//  List list = new ArrayList();				//업캐스팅
	ArrayList list = new ArrayList();
	
//	boolean add(Object e)
	list.add("하나");
    list.add(2);
	list.add(2);
	list.add(3.42);
	list.add("넷");
	list.add("five");
	list.add(6);

	System.out.println(list); //입력 순서대로 출력된다. 중복 데이터도 저장한다.
	
  }    
}                                                                                           
