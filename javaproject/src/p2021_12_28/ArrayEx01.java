package p2021_12_28;

public class ArrayEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// 배열: 동일한 자료형의 데이터를 저장하기 위한 정적인 자료구조(동적으로 데이터 공간을 넓힐 수 없다는 의미.즉 이미 값을 정해 놓으면 변화X)
// 변수 -> 배열 -> 자료구조(List)	즉,List 인터페이스 중 하나.(동적인 자료구조이며, 여러 자료형을 저장 가능) 	

//		   *[]괄호가 하나이면 1차원 배열이고 괄호는 메소드 뒤나(int[]), 변수명 뒤(score[])에 와도 상관없다.
//		   *socore 변수에 주소값이 생성되고 heap메모리에 4byte짜리 3개의 방이 형성된다. 
//		       각각의 방은 0,1,2 순서이며, 0번방은 80점 할당, 1번방은 90점 할당, 등 값을 설정한다. 
//		          
//		   *int형 배열은 초기값이 자동으로 0이 설정됨.
// 1차원 배열 첫번째 형식: 배열에 저장될 값이 정해져 있지 않는 경우에 주로 사용
		    int[] score =  new   int[3];
//		       자료형    배열변수     연산자    자료형 [배열의 크기(=방의 갯수)]
		    System.out.println(score[0]); //초기값이 0으로 자동설정됨
		    System.out.println(score[1]); //초기값이 0으로 자동설정됨
		    System.out.println(score[2]); //초기값이 0으로 자동설정됨
		
		    score[0]=80;                   //0번 방에 80점 할당
		    score[1]=90;				   //1번 방에 90점 할당
		    score[2]=100;				   //2번 방에 100점 할당
		
		    System.out.println(score[0]);  //80
		    System.out.println(score[1]);  //90
		    System.out.println(score[2]);  //100
		    
		    //double형 배열은 자동으로 0.0으로 초기화가 된다.
		    double[] d = new double[3];
		    System.out.println(d[0]);      //0.0
		    System.out.println(d[1]);      //0.0
		    System.out.println(d[2]);      //0.0
		    
		    //char형 배열은 자동으로 초기화X
		    char[] c = new char[3];
		    System.out.println(c[0]);
		    System.out.println(c[1]);
		    System.out.println(c[2]);
		    
		    //boolean형 배열은 false로 초기화
		    boolean[] b = new boolean[3];
		    System.out.println(b[0]);       //false
		    System.out.println(b[1]);		//false
		    System.out.println(b[2]);		//false
		    
		    //String형은 배열은 null로 초기화
		    String[] str = new String[3];
		    System.out.println(str[0]);		//null(값이 없다는 의미)
		    System.out.println(str[1]);		//null
		    System.out.println(str[2]);		//null
		    str[0] = "자바";
		    str[1] = "오라클";
		    str[2] = "스프링";
		    System.out.println(str[0]);		//자바
		    System.out.println(str[1]);		//오라클
		    System.out.println(str[2]);		//스프링
		    
// 1차원 배열 두번째 형식: 배열 선언과 동시에 초기화를 할때 주로 사용		    
//                   배열에 할당될 값이 정해져 있는 경우에 사용		    
		int[] s1 = {80, 90, 100};   //0번 방에 80, 1번에 90, 2번에 100 할당한 것
		int[] s2 = new int[] {80, 90, 100};
		//위의 두가지 방식 모두 같은 의미 new연산자를 안써도 된다.
		
		System.out.println(s1[0]);      //80
		System.out.println(s1[1]);		//90
		System.out.println(s1[2]);		//100
		System.out.println("배열의 크기:"+s1.length); //length는 방의 개수를 나타내는 것. 속성이기 때문에 괄호 안넣음
													//s1.length = 3		
		for(int i=0; i<s1.length; i++) {  //조건식에 i<3대신 i<s1.length 써도 됨. 단<=은 안됨 예외변수 발생
			System.out.print(s1[i]+"\t");
		}
		    System.out.println(); //세로로 줄바꿈
		    
		double[] dd = {3.14, 10.5, 42.195, 50}; //double형에 int형 50을 넣어도 형변환 되서 50.0으로 나옴
												//단, int형에 double형 값을 넣으면 오류발생. double형이 더 큰 데이터기 때문
		for(int i=0; i<dd.length; i++) {		//for문 안에 int형은 블록형의 지역변수이기 때문에 i를 똑같이 써도 괜찮음	
			System.out.print(dd[i]+"\t");
		}
		    System.out.println();// 줄바꿈
		    
		char[] cc = {'j','a','v','a','자','바'};
		for(int i=0; i<cc.length; i++) 
			System.out.print(cc[i]+"\t");
		System.out.println();// 줄바꿈
		
		boolean[] bb= {true, false, true};
		for(int i=0; i<bb.length; i++)
			System.out.print(bb[i]+"\t");
		System.out.println();
		
		String[] str1 = {"자바","오라클","스프링","파이썬","텐스플로우"};
		String[] str2 = new String[] {"자바","오라클","스프링","파이썬","텐스플로우"};
		for(int i=0; i<str1.length; i++)
			System.out.print(str1[i]+"\t");
		System.out.println();
		
		
		
		
		
		
		
		
		
		
	}

}
