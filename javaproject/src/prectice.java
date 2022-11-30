import java.util.Scanner;

public class prectice {
// 과제 2021 12 22 if else, else if 써서 풀어보기
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("정수 3개를 입력하여 최대값과 최소값을 구하세요.");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] n1 = new int[N];
		
		int min = -1000000;
		int max = 1000000;
		
		for(int i=0; i<=N; i++) {
			n1[i] = sc.nextInt();
			
			min = Math.min(min, n1[i]);
            max = Math.max(max, n1[i]);

		}
		System.out.println(max+""+min);
	}
}
