package p2022_01_11;

import java.util.Enumeration;
import java.util.Hashtable;
class HashTableTest02{
  public static void main(String[] args) {
    Hashtable<String, String> ht= new Hashtable<String, String>( );
//    put(Object key, Object value)
    ht.put("사과", "Apple");
    ht.put("딸기", "StrawBerry");
    ht.put("포도", "Grapes");      
//    ht.put("test", 30);				//오류발생      
    
    // 해쉬 테이블의 값을 키를 이용하여 얻는다.
//    Object get(Object key)
    String Val = ht.get("포도");   		//다운 캐스팅 : Object로 결과 값을 돌려줘야 하는데 String값으로 받기 때문에//String 자료형을 작성하는 것 생략가능
    if(Val != null) {
      System.out.println("포도-> " + Val);
    }  
//	 key를 모르는 경우에 사용하는 방법
//  열거형(Enumeration)인터페이스 : 딸기, 사과, 포도
    Enumeration<String> Enum = ht.keys();  //해쉬 테이블의 키 요소들에 대한 Enumeration 객체 반환
    while(Enum.hasMoreElements()){     
      String  k = Enum.nextElement();  		//다운캐스팅 //String 자료형 생략 
      String  v = ht.get(k);             	//다운캐스팅 //String 자료형 생략
      System.out.println(k + " : "+ v ); 
    }
  }    
} 