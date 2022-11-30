package p2021_12_27;

public class While04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//while문을 이용해서 구구단(2~9단)을 출력하는 프로그램을 작성하세요?

		int i, dan = 2;						//초기값
		while(dan<=9) {						//조건식
			System.out.println("["+dan+"]단");
			i = 1;						//초기값
			while(i<=9) {					//조건식
				System.out.println(dan+"*"+i+"="+dan*i);
				i++;						//증감식
			}
			System.out.println();			//줄간격 벌리기
			dan++;							//증감식
		}
			
		
		//나는 i=1을 밑에 하면 왜 오류가 걸릴까?
		

	}

}
