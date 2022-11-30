package p2021_12_23;

public class If01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		if(조건식) { 
//		조건식이 참인 경우 실행될 문장;
//		}
// 조건식 만들 때 반드시 괄호 넣어야함. 괄호 없으면 실행X
		
		if(10>5)  {
			System.out.println("실행1");
		}
		//실행될 문장이 1줄인 경우에는 중괄호({})를 생략할 수 있다.
		if (10>5) System.out.println("실행2");

		// 조건문에 true가 들어가면 무조건 실행되어 출력됨
		if(true) {
			System.out.println("무조건 실행"); 
		}
		
		// 조건문에 false가 들어가면 실행X 출력X
		if(false) {
			System.out.println("실행 안됨");
		}
		// if문에 중괄호({})가 없으면, if문 바로 아랫쪽 1줄만 if문의 적용을 받음.
		// 2줄은 조건식 적용X 무조건실행O 출력O

		if(10>30)
			System.out.println("출력안됨");//조건문이 거짓이기 때문 출력X
		    System.out.println("조건식의 적용을 받지않고 실행,출력됨");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
