package p2022_01_06;

// p296 ~ 297
// 메소드 오버라이딩(Method Overriding)
// : 부모 클래스로 상속받은 메소드를 자식 클래스에서 재정의 해서 사용하는 것

class Calculator{						// 부모 클래스
	double areaCircle(double r) {		//원의 면적
		System.out.println("Calculator 객체의 areaCircle() 실행");
		return 3.14159 * r * r;
	}
}

class Computer extends Calculator{


	@Override			//@: 어노테이션 이것이 붙어 있으면 내부적으로 잘 되나 검토함.
	double areaCircle(double r) {		// 메소드 오버라이딩
//		super.areaCircle(r);
		System.out.println("Computer 객체의 areaCircle() 실행");
		// TODO Auto-generated method stub
		return Math.PI * r * r;
	}		
//메인메소드를 여기에 형성 시켜도 되지만, 보통은 그냥 메인메소드가 있는 클래스를 따로 만든다.
	
}

public class ComputerEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int r = 10;
		Calculator cal = new Calculator();
		System.out.println("원의 면적:"+ cal.areaCircle(r));
		
		// 자식클래스에서 메소드 오버라이딩 된 메소드만 호출된다.
		Computer comp = new Computer();
		System.out.println("원의 면적:"+ comp.areaCircle(r));
	}

}



