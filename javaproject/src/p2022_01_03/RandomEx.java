package p2022_01_03;

import java.util.Random;

public class RandomEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// 난수 발생 방법: 1. Math. random()
//			   2. Random 클래스-->Import 해야함			
		
		Random r = new Random();
		
		int n1 = r.nextInt(10); //넣은 숫자 10은 제외되고 난수가 발생함.
		System.out.println("n1="+n1);
		
		//1~45 사이의 난수 발생
		
		int n2 = r.nextInt(45)+1;//0~44까지 난수 나오니까 +1을 해서 1~45가 나오게 한다.
		System.out.println("n2="+n2);
		
		//1~45 사이의 난수 6개 발생
		for(int i=1; i<=6; i++) { //i는 단순히 루프를 돌리는 횟수를 위한 것.
			int n3 = r.nextInt(45)+1; //1~45
			System.out.println(n3+"\t");
		}
		System.out.println();
		
		//0.0<=Math.random()<1.0
		
		int n4 = (int)(Math.random()*45)+1;
		System.out.println("n4="+n4);
		
		
		
		
		
		
		
		
		
	}

}
