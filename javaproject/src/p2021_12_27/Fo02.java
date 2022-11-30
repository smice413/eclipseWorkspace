package p2021_12_27;

public class Fo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// 합 누적되기 위해 초기값 0으로 무조건 해야함!
		int sum = 0;				//지역 변수(local variable): main()메소드 안에서만 사용가능
		for(int i=1; i<=10; i++ ) { //지역 변수(local variable): for문 안에서만 사용가능
									//만약 for문 밖에서 i를 입력하여 사용하면 오류발생. 즉 지역변수이기 때문
			sum = sum+i;            //sum += i;
//			1=0+1		
//			3=1+2
//			6=3+3		
//			10=6+4
			System.out.println("1~"+i+"="+sum);
		}
		// System.out.println(i); //for문 밖에 쓰면 오류발생(지역변수 이기 때문)
		System.out.println("sum="+sum);
	}

}
