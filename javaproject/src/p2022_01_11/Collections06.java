package p2022_01_11;

import java.util.Vector;

class Collections06 {
  public static void main(String[] args) {
	  
	  //제네릭(Generic) : 한가지 자료형의 데이터만 저장 하도록 해준다.
	  
	  
    Vector<String> vec = new Vector<String>();

	vec.add("Apple");
    vec.add("banana");
	vec.add("oRANGE");
//	vec.add(50); //String형 데이터만 저장 할 수 있다.
	
//	Object get(int index)	
	String temp;
    for(int i=0; i<vec.size(); i++){
      temp=vec.get(i);  //String 제네릭을 썼기 때문에 String자료형을 앞에 쓰는 것 생략가능.
      System.out.println(temp.toUpperCase());	//toUpperCase()는 대문자로 변환시켜주는 메소드
    }
  } 
}                                                                                           
