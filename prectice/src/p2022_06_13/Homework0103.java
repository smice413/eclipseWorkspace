package p2022_06_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homework0103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		int age = sc.nextInt();
		String email = sc.next();
		String address = sc.nextLine();
//		MemberInfo info = new MemberInfo(name, age, email, address);
//		info.print();
		
		
		MemberInfo info = new MemberInfo();
		info.setName(name);
		info.setAge(age);
		info.setEmail(email);
		info.setAddress(address);
	    
		List<MemberInfo> list = new ArrayList<MemberInfo>();
		for(int i=0; i<3; i++) {
			list.add(i, info);
			
		}
		for(Object s : list) {
			System.out.println(s);
		}
	
	}

}

class MemberInfo {
	private String name;
	private int age;
	private String email;
	private String address;

	// 생성자
//	public MemberInfo(String name, int age, String email, String address) {
//		this.name = name;
//		this.age = age;
//		this.email = email;
//		this.address = address;
//	}

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

	public String toString() {
		return "name:" + name + "age:" + age + "email:" + email + "address:" + address;
	}
}
