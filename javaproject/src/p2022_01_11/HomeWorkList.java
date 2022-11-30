package p2022_01_11;
//키보드를 통해서 각 회원들의 정보를 입력 받는                        
//클래스(MemberInput)를 작성한다. 
//이때 입력 받는 회원의 정보는 성명, 나이, 이메일, 주소를  
//입력 받는다. 
//그리고 키보드로 입력한 회원의 정보는 새로운
//회원정보를 저장하는 클래스(MemberInfo)의 멤버변수에 
//저장을 시킨후 출력하는 프로그램을 작성하시오.
//(단, 1명의 회원정보를 입력 받아서 처리한다. 
// 가능하면 2명 이상의 회원 정보도 입력 받아서 처리 해본다.)
//List 자료구조를 이용해서 문제를 해결하세요.
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HomeWorkList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List li = new ArrayList();
		
		String yn;
		Scanner sc = new Scanner(System.in);
		String name, email, address; 
		int age;
		
		do {
			System.out.print("성명을 입력하세요? ");
			name = sc.nextLine();
			System.out.print("나이를 입력하세요? ");
			
				
			try{
			age = sc.nextInt();		//값을 잘 못 입력하면 에러가 나서 강제 종료 될 수 있기 때문에 안전한 종료를 위해서는 예외처리를 해주는게 좋다. 
			sc.nextLine(); 			
			System.out.print("E-Mail을 입력하세요? ");
			email = sc.nextLine();
			System.out.print("주소를 입력하세요? ");
			address = sc.nextLine();
			
			MemberInfo mb = new MemberInfo(name,age,email,address);
			li.add(mb);
			}catch(InputMismatchException excep) {
				System.out.println("숫자를 제대로 입력하셨나요?");
				break;
				
			}
		
			

			System.out.print("계속할려면 y, 멈출려면 n을 입력?");
			yn = sc.nextLine();
			if (yn.equals("y") || yn.equals("Y")) {
				continue;
			} else if (yn.equals("n") || yn.equals("N")) {
				break;
			}

		} while (true);

		for (int i = 0; i<li.size(); i++) {
			Object n = li.get(i); 
//			((MemberInfo)n).print(); 
			//(MemberInfo)n은 Object 클래스를 MemberInfo로 다운캐스팅 시키는 것. 그래서 getter를 Sting, int로 받을 수 있다.
			System.out.println("성명:" + ((MemberInfo)n).getName());
			System.out.println("나이:" + ((MemberInfo)n).getAge());
			System.out.println("E-Mail:" + ((MemberInfo)n).getEmail());
			System.out.println("주소:" + ((MemberInfo)n).getAddress());
		}
	}

}


class MemberInfo /* (extends Object) */{ //Object가 묵시적으로 자동 상속된다.
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


