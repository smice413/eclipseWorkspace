package p2022_01_11;
//수강생 손정은님이 하신 과제
import java.util.*;

class MemberInfo01 {	//회원정보 형식을 지정하는 클래스
	
	//필드
	private String name;
	private int age;
	private String email;
	private String address;
	
	//생성자
	public MemberInfo01(String name, int age, String email, String address) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.address = address;
	}
	
	// Getter 메소드
	public String getName() 	{ return name;}
	public int getAge()			{ return age;}
	public String getEmail()	{ return email;}
	public String getAddress()	{ return address;}
}


public class MemberInputson {		//메인 클래스
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//MemberInfo클래스로 만든 객체(인스턴스)의 주소값을 저장하는 리스트
		List<MemberInfo01> l = new ArrayList<MemberInfo01>(); 
		
		while(true) {
			// 회원정보 입력부분
			System.out.print("학생이름  >> ");
			String name = sc.nextLine();
			
			System.out.print("나이(숫자만) >> ");
			int age = sc.nextInt();
			sc.nextLine();

			System.out.print("이메일  >> ");
			String email = sc.nextLine();
			
			System.out.print("주소  >> ");
			String address = sc.nextLine();
			
			MemberInfo01 m = new MemberInfo01(name, age, email, address);
			l.add(m); 	//리스트에 바로 위에서 생성한  MemberInfo객체(인스턴스)의 주소값 저장
		
			//추가로 입력할 건지 입력을 종료할건지 결정하는 부분
			System.out.print("계속 입력하시려면 Enter \n중단하시려면 'n'을 눌러주세요");
			System.out.print(" >> ");
			String yn = sc.nextLine();
			
			if (yn.equals("n") || yn.equals("ㅜ")|| yn.equals("N")) break;
			else continue;
		} 
		
		// 회원정보 출력부분
		for (int j=0; j<l.size();j++) {
			MemberInfo01 m = l.get(j); 	//j번째 List의 주소값을 가져옴
			System.out.println(m.getName());
			System.out.println(m.getAge());
			System.out.println(m.getEmail());
			System.out.println(m.getAddress());
			System.out.println("----------------------");
		}
	}
}
