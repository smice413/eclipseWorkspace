package p2022_06_13;

public class Menjebjaryu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// 1. 자연수의 자릿수 합 구하기
// N의 각 자릿수의 합을 구해서 Return하는 함수를 작성해 주세요.
	
// 조건 - N은 100,000,000 이하의 자연수
//		N을 자료형 변환해서 사용X
		
//		Ex) N = 2468 이면, 2+4+6+8 = 20, 20을 리턴
		
		int N = 2468;
		//System.out.println((int)Math.log10(N)+1);
		System.out.println(solution(N));
		
	}
	public static int solution(int N) {
		
		int n2 = 0;
		while(N>=1) {
			int n1 = N%10;
			n2 += n1;
			N /= 10;
		}
		return n2;
	}
	
}