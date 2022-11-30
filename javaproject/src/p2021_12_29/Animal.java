package p2021_12_29;

public class Animal {
//           사용자 정의 클래스(자료형이다.)

	int age;	//멤버변수, 필드(field), 전역변수 -->객체를 생성할 때 heap 영역에 저장된다.
				//: 메소드 바깥쪽에서 정의되는 변수 . 클래스 안에 있는 변수
				//public이 앞에 생략되었지만 static은 올 수 없다. heap영역이 아닌 static(공유) 영역에 저장된다.
	
	public Animal() {//생성자는 반드시 클래스 명과 동일해야함. 생성자 앞에는 접근제어자만 온다.
					//()안에 매개변수가 없는 것을 기본 생성자(Default Constructor)
					//*생성자는 필드값을 초기화하는 역할함.
		System.out.println("생성자 호출 성공");
	}
	
	//main()메소드 안에 있는 지역변수는 stack 영역에 저장된다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 10; //지역변수 stack 영역에 저장
		
		String str = new String("자바");
		
		Animal    a1             =     new      Animal();
//		클래스        래퍼런스(참조형)변수            연산자         위의 생성자 호출하라는 코드(이것이 생성자X)
//new연산자 쓰면 Animal 객체가 생성되면 a1은 stack영역에 저장되고, int형 멤버변수는 heap 영역에 저장되며 초기값 0이 자동으로 설정됨.
//그리고 생성자 호출되면 생성자에 작성한 syso가 호출되어 출력 가능하게 된다. 
//생성자를 별도로 만들지 않으면 컴파일러가 생성자를 자동으로 형성하고 클래스 객체를 형성하여 생성자를 호출하면 내부적으로 실행됨.		
		
//		System.out.println(age); -->오류발생
		System.out.println(a1.age);  //레퍼런스변수.필드 -->0으로 초기값이 설정되기 때문에 출력하면 0이 나온다.
		a1.age = 5;					//필드에 5라는 값을 할당하는 법	
		System.out.println(a1.age); //5
		
		Animal a2 = new Animal();
		System.out.println(a2.age); //0
		
		if(a1 == a2) {				//참조하는 주소값 비교
			System.out.println("같은 주소");
		}else {
			System.out.println("다른 주소");
		}
		if(a1.equals(a2)) {				//참조하는 값 비교
			System.out.println("같은 값");
		}else {
			System.out.println("다른 값");
		}
		
		
		
		
	}

}
