package p2022_01_06;


//추상 클래스  
//자체적으로 객체를 생성할 수 없기 때문에 생성자를 작성하고 호출하여도 사용 못함.
public abstract class AbsClass {

	int a = 10;								//일반 필드
	void check() {							//일반 메소드
		System.out.println("메소드 호출 성공");
	}
	
	abstract void absmethod(); 				//추상 메소드   //void대신 자료형 와도 되고 매개변수도 정의할 수 있다.
	                                                   //단지 내용을 쓸 수 없기 때문에 ;을 쓴다.
													   //하위 클래스들은 반드시 메소드 오버라이딩을 해야함.
													   //하위 클래스에서 자료형으로 상속받아 사용하면 하위 클래스 메소드에서 return 구문을 추가해야한다.
	
}
