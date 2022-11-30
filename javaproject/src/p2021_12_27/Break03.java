package p2021_12_27;

public class Break03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//난수 발생: 0.0<=Math.random()<1.0		
		
		int i=1;
		while(true) {
			int num = (int)(Math.random() * 45) +1; //난수 발생 1~45
			System.out.println(num);
			
			if(num==6)break;						//무한 루프를 빠져 나옴
			i++;//i++의 위치에 따라 밑의syso의 i는 달라짐 즉, i++이 위로 가면 i-1로 써야 루프횟수가 맞음
		}
		System.out.println("루프횟수:"+i);
		System.out.println("프로그램 종료");
		
		
		
	}

}
