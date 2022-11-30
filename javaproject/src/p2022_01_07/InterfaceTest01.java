package p2022_01_07;

interface IHello01 {					//인터페이스
	void sayHello(String name);			//추상 메소드(public abstract) 생략
}

class Hello01 implements IHello01 {



	@Override
	public void sayHello(String name) { //public 붙여서 메소드 오버라이딩 반드시 해야함.
		// TODO Auto-generated method stub
		System.out.println(name + "씨 안녕하세요!");
	}

}

class InterfaceTest01 {
	public static void main(String[] args) {
		
//		IHello01 ih = new IHello01(); //인터페이스는 자체적으로 객체 생성을 할 수 없다.
		
		Hello01 obj = new Hello01();
		obj.sayHello("홍길동");
		obj.sayHello("이순신");
	}
}
