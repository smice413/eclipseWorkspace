package p2021_12_31;



// p227
// 클래스 내부에서 메소드 호출 : 메소드 안에서 다른 메소드 호출

class Calculator1{
	int plus(int x, int y) {	
		int result = x + y;			// 17
		return result;
	}
	
	double avg(int x, int y) {
		double sum = plus(x, y);	// plus() 메소드 호출 //같은 클래스 안이기 때문에 생성자 객체 필요없음.
		double result = sum / 2;	// 8.5
		return result;
	}
	
	void execute() {
		double result = avg(7, 10);	// avg() 메소드 호출
		println("실행결과:"+ result); // println() 메소드 호출
	}
	
	void println(String message) { //위의 println("실행결과:"+ result); 지금 이 메소드를 호출한것.
		System.out.println(message);
	}
}

public class CalculatorEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator1 mycal = new Calculator1();
		mycal.execute(); 	// execute() 메소드 호출
//		execute();          // 오류발생 static(정적 메소드)가 아니기 때문에 객체를 통해서 호출해야함.
	}

}
