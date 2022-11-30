package p2022_01_03;

final class FinalClass { //부모 클래스 앞에 final이 붙어 있어서 상속 받는 자식 클래스가 오류발생함.즉, 상속 X
	String str = "Java ";

	public void setStr(String s) {
		str = s;
		System.out.println(str);
	}
}

class FinalEx extends FinalClass { //자식 클래스
	int a = 10;

	public void setA(int a) {
		this.a = a;
	}

	public void setStr(String s) {
		str += s;
		System.out.println(str);
	}
}

public class FinalTest03 {
	public static void main(String[] args) {
		FinalEx fe = new FinalEx();
	}
}