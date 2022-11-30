package p2022_01_03;

class FinalMethod {
	String str = "Java ";

	// public void setStr(String s) {
	// final 붙이면 서브 클래스에서 오버라이딩이 불가. *메소드 오버라이딩: 부모의 메소드를 마치 자식의 영역에서 원래 있었던 것처럼 이름과 형식을 똑같이 쓸 수 있지만, 내용만 다르게 기술하는 방법
	public final void setStr(String s) {
		str = s;
		System.out.println(str);
	}
}				//상속은 필드O 메소드O, 생성자X 가능하다.
			  //extends는 FinalEx(자식)가 FinalMethod(부모)에게 상속 받는다는 의미	
class FinalEx extends FinalMethod {
	int a = 10; // final 붙이면 밑에서 a값 대입 불가.

	public void setA(int a) {
		this.a = a;
	}

	public void setStr(String s) { //메소드 오버라이딩을 하려고 했지만 위의 부모 메소드가 final이 붙어 있기 때문에 쓸 수 없다.
		str += s;
		System.out.println(str);
	}

}

public class FinalTest02 {
	public static void main(String[] args) {
		FinalEx ft = new FinalEx();
		ft.setA(100);
		ft.setStr("hi");// 슈퍼 클래스의 setStr을 실행.
		FinalMethod ft1 = new FinalMethod();
		ft1.setStr("hi");// 자신의 클래스의 setStr을 실행.
	}
}