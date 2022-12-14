package p2021_12_31;

import java.util.Arrays;

class Lotto1 {

	public static void main(String[] args) {

		int num[] = new int[6];

		for (int i = 0; i < num.length; i++) {

			num[i] = (int) (Math.random() * 45) + 1;
//			num[0]=5, num[1]=5,
			for (int j = 0; j < i; j++) {
				if (num[i] == num[j]) {
					i--;
					break; //break; 문을 써야 하는 이유가 계속 난수 발생시키면 6개가 안나올 때가 있다.
				} // if end

			} // for end
		} // for end

		
		// 오름차순 정렬 : 버블정렬(자신의 옆자리에 있는 것과 비교)
		int temp = 0;
		for (int i = 0; i < num.length; i++){
			for (int j = i+1; j < num.length; j++) {
				if(num[i] > num[j]){
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}

		//Arrays.sort(num); // 오름차순 정렬

		for (int k : num) {
			System.out.print(k + "\t");
		}
	}
}

/*
 * 난수 발생 공식 난수 =(정수화) ((상한값-하한값+1)* Math.random()) + 하한값
 * 
 */