package p2021_12_28;

public class ArrayEx05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//향상된 for문
//형식: for(타입 변수 : 순차적인 자료구조(배열, 컬렉션)) {
//			실행문;		
//		}
		
		int[] score = {95, 71, 84, 93, 87};
		
		//기본 for문
		int sum = 0;
		for(int i=0; i<score.length; i++) {
			sum+=score[i]; 
		}
		System.out.println("총점:"+sum);
		
		//향상된 for문
		int sum1 = 0;
		for(int s : score) { //score값이 전부 쓰일 때 까지 int s 변수에 반복 누적 시킴
			sum1+=s;
		}
		System.out.println("총점:"+sum1);
		
		
		
	}

}
