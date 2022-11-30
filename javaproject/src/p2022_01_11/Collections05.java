package p2022_01_11;

import java.util.Vector;

class Collections05 {
  public static void main(String[] args) {

//제네릭을 사용하지 않으면, 여러가지 자료형의 자료를 모두 저장할 수 있다.	  
    Vector vec = new Vector();
    
//    add(Object e)
	vec.add("Apple");					//업캐스팅
    vec.add("banana");
	vec.add("oRANGE");
//	vec.add(50);
//	vec.add(3.14);
//	vec.add('k');
//	vec.add(true);
	
	
	
	
//	Object get(int index)
	String temp;
    for(int i=0; i<vec.size(); i++){
		temp=(String) vec.get(i);       //다운 캐스팅
//		temp=vec.get(i);				//오류발생  다운캐스팅할 때 String자료형값을 앞에 붙어야함.
		System.out.println(vec.get(i));
		System.out.println(temp.toUpperCase());
	}    
  } 
}                                                                                           
