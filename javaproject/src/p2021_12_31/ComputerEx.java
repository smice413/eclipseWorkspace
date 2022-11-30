package p2021_12_31;



// 220 ~ 221

class Computer{
	
	// 주소값 전달에 의한 메소드 호출(Call by Reference방식) 
	int sum1(int[] values) {
		int sum=0;
		for(int i=0; i<values.length; i++) { //length 속성을 넣어야함 values의 값이 정해지지 않았기 때문.
			sum += values[i];
		}
		return sum;
	}
	
	// vargus : 전달된 값은 배열로 받음
	int sum2(int ... values) {
		int sum=0;
		for(int i=0; i<values.length; i++) {
			sum += values[i];
		}
		return sum;
	}
}

public class ComputerEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer com = new Computer();
		
		int[] values1 = {1, 2, 3};
		int result1 = com.sum1(values1);	// sum1()메소드 호출 //데이터가 많을 때 주소값을 넣어서 전달.
		System.out.println("result1:"+ result1);
		
		int result2 = com.sum1(new int[] {1,2,3,4,5}); // sum1()메소드 호출//주소값으로만 전달하는 것은 heap메모리에 남지만 이것과 같이 데이터도 같이 넘기는 주소값은 일시적 저장만하고 지워짐.
		System.out.println("result2:"+ result2);
		
		int result3 = com.sum2(1,2,3);		//sum2()메소드 호출
		System.out.println("result3:"+ result3);
		
		int result4 = com.sum2(1,2,3,4,5);	//sum2()메소드 호출
		System.out.println("result4:"+ result4);
	}

}
