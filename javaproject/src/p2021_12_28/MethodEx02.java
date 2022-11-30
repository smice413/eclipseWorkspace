package p2021_12_28;

public class MethodEx02 {

	//1~n까지 합을 구하는 메소드
	static void sum(int n) {//sum메소드 안에 매개변수 int n을 선언했기 때문에 정수로 호출해야함
		int hap = 0; //지역변수이기 때문에 자동으로 초기값 설정 안되기 때문에 따로 설정해야함.즉, 메모리 상에서 한번 저장실행되고 끝나면 삭제되기 때문
		for(int i=1; i<=n; i++) {
			hap += i;
		}
		System.out.println("1~"+n+"="+hap);
	}
	//void는 값을 돌려주지 않기 때문에 변수형태로 저장 안됨. int로 바꾸면 return으로 값을 돌려 받고 변수형태로 저장하여 출력.
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sum(3);
		sum(5);
		sum(10);
		sum(30);
		sum(50);
		sum(100);
		sum(1000);
		sum(10000);

		
	}

}
