package p2021_12_28;

public class ArrayEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//교재 152~153p에 있는 예제	
		
		int[] score = {83, 90, 87};
		
		System.out.println("score[0]:"+score[0]);
		System.out.println("score[1]:"+score[1]);
		System.out.println("score[2]:"+score[2]);
		
		int sum = 0;
		for(int i=0; i<score.length; i++) {
			sum += score[i];
		}
		System.out.println("sum="+sum);   //sum: 260
		
		double avg = sum/3.0; //int형이 double형으로 형변환 한다고 해도 소수점이 사라지기 때문에 
		 System.out.println("평균:"+avg);                     //같은 double형으로 만들어 주는게 좋다.
		
		//평균값을 소숫점 2째자리까지 출력 하세요?
		System.out.printf("평균: %.2f", avg);//소수점 2째 자리 구하려면 prinf로 하고 "%.2f", avg 쓰면됨
		
		
		
		
		
	}

}
