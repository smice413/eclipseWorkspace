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
	
	
    public void print() {
		System.out.println("이름:"+name);
		System.out.println("나이:"+age);
		System.out.println("이메일:"+email);
		System.out.println("주소:"+address);
	}
		
	
	
	
}

public class MemberInputHomeWork00 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("정보를 입력하세요?");
		Scanner sc = new Scanner(System.in);
		String name, email, address;
		int age;
		name = sc.nextLine();
		age = sc.nextInt();
		sc.nextLine();
		email = sc.nextLine();
		address = sc.nextLine();
		MemberInfo info = new MemberInfo(name, age, email, address);
		
		info.print();	
		


	}
}
