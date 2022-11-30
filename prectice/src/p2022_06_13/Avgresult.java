package p2022_06_13;

public class Avgresult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// 3. 평점 계산기
// 심사위원 10명이 각각 0-100 사이의 자연수로 평가 점수를 제출합니다. 10개의 평가 점수를 담은 배열 A가 주어지면 다음과 같은 조건으로 평점을
// 계산하고 계산된 평점 SCORE를 return 하는 함수를 작성해 주세요.
// 평점 계산 조건
// -10개의 평점 중 최고점, 최저점은 제외됨
// -최고/최저점이 제외된 점수의 평균을 계산하고 소수점 첫 번째 자리에서 반올림하면 평점이 산출됨
// ex)
// A = [50,50,10,50,50,100,50,50,50,50]
// 최저점 10, 최고점 100을 제외하고 평균값은 50
// SCORE = 50		
		int[] A = {50,50,10,50,50,100,50,50,50,50};
		score(A);
		
		
	}
	
	public static int score(int[] a) {
		int result = 0;
		int max = a[0];
		int min = a[0];
		int A = 0;
		for(int i=0; i<a.length; i++) {
			if(max < a[i]) max = a[i];
			if(min > a[i]) min = a[i];
			A += a[i];
			
			
		}
		System.out.println(max);
		System.out.println(min);
		
		System.out.println("score="+(A-max-min)/(a.length-2));
		
		return result;
	}

}
