package p2021_12_30;

public class HomeWork2021_12_30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//구구단(2~9단)의 연산 결과를 2차원 배열에 저장하고,
//	       배열에 저장된 결과를 이용해서 구구단을 출력하는 
//	       프로그램을 작성하세요?
		
		int[][] ggd = new int [8][9];
		
		for(int i=0; i<8; i++) { //0행 0열에 구구단 값을 저장하기 위해 i와 a의 초기값을 0으로 설정해야함
			for(int a=0; a<9; a++) {
				ggd[i][a]=(i+2)*(a+1);
			
				System.out.print((i+2)+"*"+(a+1)+"="+ggd[i][a]+"\t");
			}
			System.out.println();
		}

     }
}
