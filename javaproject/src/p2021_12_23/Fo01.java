package p2021_12_23;

public class Fo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		 for문
//		 for(초기값; 조건식; 증감식){
//		       반복 실행할 문장;
//		    }
//		조건식이 참이 될 때만 실행문장이 반복 될 수 있지만, 조건식 거짓이면 하나도 실행 안될 수 있다.
		
		//사랑해요 메세지를 10번 출력 하세요?
		//int i;로 변수 설정 해두고 초기값에 i=1로 해도됨
		for(int i=1; i<=10; i++) {//i<11이것도 됨, 증감식은 ++i, i=i+1, i+=1도 같음
			System.out.println(i+"사랑해요~!!");
		}
		
	}

}
