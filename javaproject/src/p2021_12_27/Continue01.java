package p2021_12_27;

public class Continue01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//continue문
// 1. 다시 반복문으로 돌아가라는 의미를 지님.		
// 2. continue문이 실행되면, continue문 아랫쪽의 내용들은 실행되지 않고
//    다시 반복문으로 돌아간다.
		
		for(int i=1; i<=10; i++) {
			
			if(i==5) continue; //continue문은 출력 전에 위치해야 실행가능
			System.out.println("출력:"+i);
			
		}
		
		
		
		
	}

}
