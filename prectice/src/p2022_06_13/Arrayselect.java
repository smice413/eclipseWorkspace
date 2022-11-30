package p2022_06_13;

import java.security.SecureRandom;

public class Arrayselect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] str = {"apple", "orange", "banana", "mango", "apple mango", "mangoapple"};
		
//		for(int i=0; i<str.length; i++) {
//			if(str[i].startsWith("apple")==true) {
//				System.out.println(str[i]);
//			}
//		}
		
		for(int i=0; i<str.length; i++) {
			String str1 = str[i];
			
			int str2 =str1.indexOf("apple");
			if(str2>=0) {
				System.out.println(str1);
			}
			
			
		}
	
		
	}

}
