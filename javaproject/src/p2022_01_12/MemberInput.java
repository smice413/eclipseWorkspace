package p2022_01_12;


import java.util.ArrayList;
import java.util.Scanner;

public class MemberInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//제네릭 : 한가지 자료형의 자료만 저장한다는 의미
//		ArrayList<MemberInfo> li = new ArrayList<MemberInfo>();
//		ArrayList에 MemberInfo객체만 저장 할 수 있다.
		//List 응용예제라는 폴더에서 자료 확인해봐라~
		ArrayList li = new ArrayList();
		MemberInfo mm;
		String yn;

		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("성명을 입력하세요? ");
			String name = sc.nextLine();
			System.out.print("나이를 입력하세요? ");
			int age = sc.nextInt(); //값을 잘 못 입력하면 에러가 나서 강제 종료 될 수 있기 때문에 안전한 종료를 위해서는 예외처리를 해주는게 좋다. 
			sc.nextLine();
			System.out.print("E-Mail을 입력하세요? ");
			String email = sc.nextLine();
			System.out.print("주소를 입력하세요? ");
			String address = sc.nextLine();

			MemberInfo m = new MemberInfo();	//기본생성자로 호출했기 때문에 초기화 값 설정과 수정은 setter로 한다.
			// m.name="홍길동"; 접근제어자가 private(캡슐화)이기 때문에 이렇게 접근 못함. 
			m.setName(name);
			m.setAge(age);
			m.setEmail(email);
			m.setAddress(address);

			//add(Object e)
			li.add(m);			//업캐스팅

			System.out.println("계속할려면 y, 멈출려면 n을 입력?");
			yn = sc.next();
			if (yn.equals("y")) {
				continue;
			} else if (yn.equals("n")) {
				break;
			}

		} while (true);	//무한루프 돌리기에 while문이나 do~while문이 좋다.

		for (int i = 0; i < li.size(); i++) {
			mm = (MemberInfo) li.get(i);	//Object의 자식이 MemberInfo이기 때문에 다운캐스팅 시킴.

			System.out.println("성명:" + mm.getName());
			System.out.println("나이:" + mm.getAge());
			System.out.println("E-Mail:" + mm.getEmail());
			System.out.println("주소:" + mm.getAddress());
		}
	}

}

class MemberInfo extends Object { //DTO(Data Transfer Object)
	private String name;
	private int age;
	private String email;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
