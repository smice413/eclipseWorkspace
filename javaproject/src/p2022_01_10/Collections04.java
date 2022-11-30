package p2022_01_10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Collections04 {

  public static void main(String[] args) {
    List list = new ArrayList();						//업캐스팅
//	ArrayList list = new ArrayList();

//	boolean add(Object e)
	list.add("하나");
    list.add(2);
	list.add(3.42);
	list.add("넷");
	list.add("five");
	list.add(6);
	System.out.println(list);

	System.out.println(list.get(2)); //인덱스 2번 원소 추출: 3.42
	System.out.println(list.get(4)); //인덱스 4번 원소 추출: five
	
	
	//******가장 많이 쓰는 방식임.
for(int i=0; i<list.size(); i++){
  System.out.println( i + " 번째 요소는 " + list.get(i));
	Object s = list.get(i);  //Object s 변수에 저장해야 하는게 맞지만 일반적으로 변수로써 안쓰기 때문에 하위상속받는 클래스형태로 저장함.
//	String s =(String)(list.get(i)); //요소가 String만 있는 것이 아니기 때문에 쓸 수 없다.
	
	System.out.println(s);
}

for(Object s: list) {
	System.out.print(s+"\t");
}
System.out.println();


// 반복자(Iterator)
	Iterator elements=list.iterator();    
	while(elements.hasNext()) {
      System.out.println("\t\t" + elements.next());
	}	

 } 
}                                                                                           
