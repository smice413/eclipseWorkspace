package p2021_12_27;

public class HomeWork2021_12_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		구구단(2~9단)을 열방향(세로방향)으로 출력하는 
//		 프로그램을 작성 하세요?
		for (int n = 2; n < 10; n++) {
			System.out.print("[" + n + "]단" + "\t");//각 단을 가로로 펼치면서 \t로 칸 띄우기
		}
			System.out.println();//세로로 다음 줄이 이어지도록 함
		for (int dan = 1; dan < 10; dan++) {
         //dan과 i의 숫자 위치를 바꾸고 밑의 출력 위치도 바꿈
			for (int i = 2; i < 10; i++) {
				System.out.print(i + "*" + dan + "=" + dan * i + "\t");//각 단을 가로로 펼치면서 \t로 칸 띄우기
			}
			System.out.println();//세로로 다음 줄이 이어지도록 함

		}

	}

}
