package p2022_01_03;

import java.util.Scanner;

class MemberInfo {
	
	private String name;
	private int age;
	private String email;
	private String address;
	
	public MemberInfo(String name, int age, String email, String address) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.address = address;
	}
	
	public void setname(String name) {
		this.name = name ;
	}
	public void setage(int age) {
		this.age = age ;
	}
	public void setemail(String email) {
		this.email = email ;
	}
	public void setaddress(String address) {
		this.address = address ;
	}
    public void print() {
		System.out.println("이름:"+name);
		System.out.println("나이:"+age);
		System.out.println("이메일:"+email);
		System.out.println("주소:"+address);
	}
		
	
	
	
}

public class MemberInputHomeWork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("정보를 입력하세요?");
		Scanner sc = new Scanner(System.in);
		
		
		MemberInfo info = new MemberInfo("hong", 20, "hong@naver.com", "seoul");
		info.setname(sc.nextLine());
		
		info.setage(sc.nextInt());
		sc.nextLine();// 이 구문이 들어가야 위의 nextint(숫자) 후 엔터키를 누를때  null로 리턴되는 것을 대신 받고 다음 이메일을 작성할 수 있다.
		
		info.setemail(sc.nextLine());
		info.setaddress(sc.nextLine());
		
		info.print();	


	}
}
