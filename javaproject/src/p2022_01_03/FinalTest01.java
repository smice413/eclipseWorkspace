package p2022_01_03;

class FinalMember {
	final int a = 10;		  //상수(constant)= 값을 수정X

	public void setA(int a) {//int a= 100;
		this.a = a;
	}
}

public class FinalTest01 {
	public static void main(String[] args) {
		FinalMember ft = new FinalMember();
		final int a = 1000;	//필드 값을 바꾸고 싶지만 상수이기 때문에 수정 X 오류 발생
		ft.setA(100);
		System.out.println(a);
	}
}
