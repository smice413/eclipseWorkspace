package p2022_01_04;

import java.util.Scanner;

public class MemberInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 객체 배열 : 객체의 주소를 저장하는 배열
		MemberInfo[] m = new MemberInfo[5]; //배열은 정적 자료구조이기 때문에 데이터의 한계가 있다.
		int i = 0;
		String yn;
		Scanner sc = new Scanner(System.in);
		String name, email, address; //생성자 호출의 수정값을 넣으려면 메인메소드에서 변수 선언을 또 해야하나? 해야한다.
		int age;
		do {
			System.out.print("성명을 입력하세요? ");
			name = sc.nextLine();
			System.out.print("나이를 입력하세요? ");
			age = sc.nextInt();		// 숫자를 입력받은후에 enter키를
			sc.nextLine(); 			// 누르면 null값을 return하게 됨 //sc.nextLine();을 추가 해야 null값을 대신 받고 그다음에 이메일을 쓸수 있다.
			System.out.print("E-Mail을 입력하세요? ");
			email = sc.nextLine();
			System.out.print("주소를 입력하세요? ");
			address = sc.nextLine();

			m[i] = new MemberInfo(name, age, email, address);
			// m.name="홍길동";
			i++;

			System.out.print("계속할려면 y, 멈출려면 n을 입력?");
			yn = sc.nextLine();
			if (yn.equals("y") || yn.equals("Y")) {
				continue;
			} else if (yn.equals("n") || yn.equals("N")) {
				break;
			}

		} while (true);

		for (int j = 0; j < i; j++) {
			System.out.println("성명:" + m[j].getName());
			System.out.println("나이:" + m[j].getAge());
			System.out.println("E-Mail:" + m[j].getEmail());
			System.out.println("주소:" + m[j].getAddress());
		}
	}

}

// DTO(Data Transfer Object)
class MemberInfo /* extends Object */ {
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
// 출력방식 두가지: get으로 객체에 저장되어 있는 값을 리턴 받아 호출한 곳을 통해 출력// 또는 print()메소드로 출력
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}
	
	public void print() {
		System.out.println("name:"+name+" age:"+age+" email:"+email+" address:"+address);
	}

}
