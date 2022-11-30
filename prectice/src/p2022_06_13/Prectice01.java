package p2022_06_13;

public class Prectice01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//구구단(2~9단)의 연산 결과를 2차원 배열에 저장하고,
//	       배열에 저장된 결과를 이용해서 구구단을 출력하는 
//	       프로그램을 작성하세요?
		
		int [][] gugu = new int[8][9];
		int i= 0;
		int dan=0;
		for(i=0; i<9; i++) {
			for(dan=0; dan<8; dan++) {
				gugu[dan][i] = (dan+2)*(i+1);
				System.out.print((dan+2)+"*"+(i+1)+"="+gugu[dan][i]+"\t");
			}
			System.out.println();
		}
	}

}
