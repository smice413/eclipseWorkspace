package p2021_12_29;

public class ArrayEx06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// 교재 p154 예제		
		
		int[] scores; //heap메모리에 새로운 공간이 생성되지 않았기 때문에 주소값을 가지고 있지 않다.
		scores = new int[] {83, 90, 87}; //int[] scores = new int [] {83, 90, 87}; 이것도 가능
				
		int sum1 = 0;   //지역변수
		for(int i=0; i<3; i++) {
			sum1 += scores[i];
		}
		System.out.println("총합:"+sum1);
		
		
		//add메소드를 호출해서 리턴된 총점을 sum2변수에 저장
		int sum2 = ArrayEx06.add(new int[] {83, 90, 87}); //호출하는 add메소드 안의 매개변수가 참조형으로 주소값을 주고 새로운 공간 형성시킴
		System.out.println("총합:"+sum2);
		
	}//main() end
//java는 메소드 안에 메소드 중첩X 대신 메소드 순서는 상관X, python은 가능
	//사용자 정의 메소드 : 합을 구해주는 메소드
	public static int add(int[] scores) { //메소드의 매개변수가 참조형으로 왔음. 그래서 주소값을 가지고 있기 때문에 주소값을 전달해서 호출하는 방식을 써야함//단 , 현재는 주소값을 가지고 있지 않음 그래서 new연산자 써야함.
		int sum = 0;  //지역변수
		for(int i=0; i<3;i++) {
			sum += scores[i];
		}
		return sum;
		
	}
	
	
	
}
