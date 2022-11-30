package p2021_12_22;

import java.util.ArrayList;
import java.util.List;

public class Variable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// 변수: 메모리 상에 데이터를 저장하기 위한 기억 공간/
//변수를 만드는 형식: 자료형  변수명=데이터(값);
//기본 자료형 변수: 지역변수(stack메모리 영역에 저장된다)
		//1. 정수형 변수
		byte b1 = 10; //byte형은 -128~127값 까지만 저장 가능함
		// byte b2 = 130; // 오버플로우 발생
		short s = 100; //-32768~32767
		int i = 1000; //-21억~21억
		long l = 2300000000l;// 값의 뒤에 대문자 소문자 L를 붙여야함 22억 넘어가면 무조건 붙어야함 안붙이면 int형으로 인식함
		
		System.out.println("b1="+b1);
		System.out.println("s="+s);
		System.out.println("i="+i);
		System.out.println("l="+l);
		//2. 실수형 변수(자료형과 변수값이 일치해야함)
		//오류발생 두가지: int f1 = 3.14f;(자료형과 변수값이 일치X) 또는 float f1 = 3.14;(변수값 끝에f를 안 붙임)
		float f1 = 3.14f;// float형은 값은 끝에 반드시 대문자나 소문자 f를 붙여야 함 안붙이면 오류 발생 즉, double형으로 인식함
		double d = 42.195;
		
		System.out.println("f1="+f1);
		System.out.println("d="+d);
		System.out.printf("%.1f\n", d); // 소수점 첫 째자리 까지만 반올림해서 표시함(printf는 \n을 넣으면 console의 줄 이동가능)
		System.out.printf("%.2f\n", d); // 소수점 2 째자리 까지만표시함
		//%d는 정수, %s는 문자, %.숫자f는 실수를 표시하는 C언어 방식
		//" ," 는 이어주는 의미 이지만 위의 방식은 System Class의 printf의 정해진 메소드 방식임 
		//3. 문자형 변수
		// char c= 'AB'; 이것은 오류 발생 2글자 이상 저장 불가능 1글자만 저장할 수 있음 
		char c1 = 'A';
		char c2 = '안';
		
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		//4. 논리형 변수
		boolean bn1 = true;
		boolean bn2 = false;
		
		System.out.println("bn1="+bn1);
		System.out.println("bn2="+bn2);
		// *기본자료형으로 문자열(두글자 이상)을 저장 못함 한글자 밖에 못하기 때문. 따라서 참조형 변수를 쓴다
		// 참조형 변수는 공통적으로 주소값을 갖는다. 즉, heap메모리에 주소값이 저장됨.
		//1. 클래스
		String s1 = "자바";
		String s2 = new String("자바");
		System.out.println("s1="+s1);
		System.out.println("s2="+s2);
		if(s1 == s2) {		// 주소 비교 ==은 비교연산자
			System.out.println("같은 주소");
		}else {
			System.out.println("다른 주소");
		}
		if(s1.equals(s2)) { // 데이터(값) 비교
			System.out.println("같은 값");
		}else {
			System.out.println("다른 값");
		}
		
		//2. 배열:동일한 자료형의 데이터를 저장하는 정적인 자료구조
        int[] score = {80, 90, 100};
		
		
		for(int j=0; j<score.length; j++) {
			System.out.print(score[j]+"\t");
		}
		System.out.println();
		//3. 인터페이스
		// 1.순차적인 자료구조
		// 2.여러가지 자료형의 데이터를 모두 저장할 수 있다.
		// 3.동적으로 공간의 크기를 늘릴 수 있다.
				
//				List list = List();				// 오류발생
				List list = new ArrayList(); //ArrayList를 import 해야함 util로 하기
				//new는  Heap메모리 영역에 할당된 필드의 주소값을 저장하라는 뜻입니다. 
				list.add(30);
				list.add(3.14);
				list.add('j');
				list.add(true);
				list.add("자바");
				
				for(int k=0; k<list.size(); k++) {
					System.out.print(list.get(k)+"\t"); //\t는 간격띄우는 것 스페이스바로 일일이 안쳐도됨
				}
		//!! 경고가 나오는 이유는 제너릭으로 한것이 아니기 때문이다. 큰 문제는 없다고 한다.
			
	}

}
