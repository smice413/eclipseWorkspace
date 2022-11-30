package p2021_12_31;

public class HomeWork2021_12_31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1~45사이의 숫자를 6개 추출 하는 프로그램을 작성 하세요? 
//		(단, 중복된 숫자는 1번만 출력 되도록 한다.)
//		 Math.random() 이용해서 프로그램을 작성 하세요.
// tip. 중복된 숫자는 1차원 배열을 써서 해결해야함.
//		 0.0 <= Math.random() < 1.0
//		
		int[] a = new int[6];
		
		for(int i = 0; i<6; i++) {
			int num = (int)(Math.random()*45+1); 
			a[i] = num;
			for(int j = 0; j<i; j++) {
				if(a[i] == a[j]) {
					i--;
					break;// break; 문을 써야 하는 이유가 계속 난수 발생시키면 6개가 안나올 때가 있다.
				}
			}
			System.out.println(a[i]);
			
		}
		
		
		
		
		
	}

}
