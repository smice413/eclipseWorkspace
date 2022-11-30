package p2022_01_03;

class StringTest01 {
	
//	1. String 객체를 생성한 후에 메소드에 의해서 값의 변화가 일어나면
//	    변경된 값을 새로운 힙메모리 영역에 다시 저장한다.	
//  2. Garbage Collection 기능(쓰레기 수집기능)
//		: 재사용할 수 없는 힙메모리 영역의 데이터를 모아서 지워주는 기능
  public static void main(String[] args) {
    String str1 = "Java Programming";
	str1.toUpperCase(); //모두 대문자로 바꿔라는 메소드        //메서드 호출 후에도 
    System.out.println(str1);                 //str1의 내용은 수정되지 않는다. 대문자로 변경된 문자가 새로운 변수 선언이 안 이루어져 저장이 안되었기 때문  
	System.out.println(str1.toUpperCase());  //대문자로 바꿔서 출력은 하지만 저장안되고 삭제됨. 재사용 불가능하다.
					//소문자는 toLowercase()	//garbage collect기능	
    String str2=str1.toUpperCase();  //메소드의 처리 결과를 str2에 저장
    System.out.println(str2);        //따라서 대문자가 heap 메모리에 저장되고 재사용가능해짐.  
  }    
}  