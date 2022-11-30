package p2021_12_27;

public class Break01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//break: 반복문을 빠져 나오는 역할
// 무한루프: for문
		
// '무한 출력' 을 100번 출력 하세요?		
		for(int i=1;;i++) {
			
			System.out.println(i+"무한 출력");
			if(i==100) break;// syso 위로 옮기면 99무한 출력에서 끝남. i가 100이 되고 출력까지 못가고 break걸렸기 때문.
		}
		
		
		
		
		
	}

}
