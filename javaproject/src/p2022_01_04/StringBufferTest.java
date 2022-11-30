package p2022_01_04;

public class StringBufferTest {
	public static void main(String[] args) {
//String buffer는 값의 변화가 일어나도 새로운 공간을 만드는 것이 아니라 같은 주소값을 가진 공간에서 변화가 일어나는 방식. String과 저장 방식이 다르다.
//String buffer와 String Builder는 String 객체의 데이터 불변성을 대체하여 값의 변화를 주기 위한 방법으로 문자열에 .append()와 같이 추가 하여 계속적으로 데이터를 변경할 수 있다.
//String buffer와 builder의 차이는 동기화 차이로 buffer는 동기화가 가능하여 멀티스레드에서 사용하기 좋고, builder는 동기화가 불가능하여 단일스레드에서는 가장 효율이 좋다. 		
		StringBuffer sb1 = new StringBuffer("gemini");
		System.out.println("sb1.length() : " + sb1.length());
		System.out.println("sb1.capacity() : " + sb1.capacity());// capacity(): 저장가능한 현재 공간의 크기를 구하는 것. 

		sb1.append("A string buffer implements" + "a mutable sequence of characters");//append():새로운 문자열을 추가하는 것
		System.out.println("sb1.length() : " + sb1.length());
		System.out.println("sb1.capacity() : " + sb1.capacity());

		StringBuffer sb2 = new StringBuffer();
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
	}
}
