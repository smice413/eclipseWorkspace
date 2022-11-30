package p2021_12_30;
//교재 p201 예제

//파일1개 + 클래스 2개 -->소스파일 1개 CarEx.java->컴파일 후 바이트 코드는 bin폴더에 Car.class 와 CarEx.class 2개가 만들어짐
//main()메소드가 있는 class는 public 접근제어자 + 클래스명(==메인메소드 이름)
//main()메소드 없는 class는 public없어야함 즉, default 접근제어자임

class Car{
   // 필드(field) 각각의 초기값이 설정된다. speed는 초기값이 int형으로 자동 0으로 설정됨
	String company = "현대 자동차";
	String model = "그랜저";
	String color = "검정";
	int maxSpeed = 350;
	int speed;
	
	public Car() { //기본 생성자 : 괄호 안에 매개변수가 없다.
		System.out.println("생성자 호출 성공");
	}
}
//class Car를 독립적으로 실행하려면 main()메소드를 만들어라.

public class CarEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CarEx car = new CarEx();//이것은 객체 형성이 가능하지만 field가 없기 때문에 무의미함.
		
		Car mycar = new Car(); //생성자는 객체를 new로 생성할 때 호출된다.
		System.out.println("제작회사:"+ mycar.company);
		System.out.println("모델명:"+ mycar.model);
		System.out.println("색깔:"+ mycar.color);
		System.out.println("최고속도:"+ mycar.maxSpeed);
		System.out.println("현재속도:"+ mycar.speed);			//0
		
		//필드값 변경
		mycar.speed = 60;
		System.out.println("수정된 속도:"+ mycar.speed);		//60	
		
	}

}
