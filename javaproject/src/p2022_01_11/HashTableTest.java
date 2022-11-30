package p2022_01_11;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

class HashTableTest {
  public static void main(String[] args) {
	  
//	Map ht = new Hashtable();	//업캐스팅   //Map에 상속해줄  keys()메소드가 없기 때문에 아래 Enumeration Enum = ht.keys();가 오류발생
  Hashtable ht= new Hashtable();
     // 해쉬 테이블에 키/데이터를 입력한다. 
//   put(Object key, Object value)
	 ht.put("딸기", "StrawBerry");		//업캐스팅
     ht.put("사과", "Apple");     
     ht.put("포도", "Grapes");         

       // 해쉬 테이블의 값을 키를 이용하여 얻는다.
//       Object get(Object key)
	 //  Object obj = ht.get("포도");
     String Val = (String)ht.get("포도");	//다운캐스팅
     if(Val != null) {
       System.out.println("포도-> " + Val);
     }  
     
//	 key를 모르는 경우에 사용하는 방법
//   열거형(Enumeration)인터페이스 : 딸기, 사과, 포도
     Enumeration Enum = ht.keys(); //keys()는 Map의 모든 key를 구해옴
     while(Enum.hasMoreElements()){	//가져올 키값이 있으면 true로 계속 실행함
         Object  k = Enum.nextElement();//키를 가져와서 k에 저장함   
         Object  v = ht.get(k);//키값에 있는 value를 가져와 v에 저장.
         System.out.println(k + " : "+ v );
     }
   }    
}                                                
