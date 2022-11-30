package p2021_12_29;

public class ArrayEx07 {

	//절대값을 구해주는 메소드
	public static int abs(int data) {
		if(data<0) {//음수
			data = -data; //-를 붙여 양수로 만들어주는 것
		}
		return data; //return 문: 메소드 호출한 곳에 값을 돌려주는 역할. 자료형 int로 메소드를 호출해서 return값도 int여야함.
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//main()메소드는 실행하려면 실행표시의 화살표 클릭->run configuration->agument-> -10 -20 입력
		//arg[0] = "-10"; <-쌍따옴표로 해서 문자로 저장됨
		
		System.out.println("args[0]:"+args[0]);
		System.out.println("args[1]:"+args[1]);
		
		// arg[0] = "-10" ----> -10 : 자료형 변환(기본자료형과 참조형을 변환시켜주는 것)
		int num = Integer.parseInt(args[0]); //Integer.parseInt 문자형태를 int형 숫자형태로 변환시켜주는 Wrapper클래스
											//java.lang에 있는 클래스라 따로 import안해도 됨
		// int num = -10 
		System.out.println("절대값:"+abs(num));//abs()메소드 호출
		
		
		
		
		
		
		
	}

}
