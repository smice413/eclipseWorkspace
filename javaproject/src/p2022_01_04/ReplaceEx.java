package p2022_01_04;

public class ReplaceEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//p506		
//replace("자바","jAVA") : 자바를 JAVA로 치환해주는 역할
		
		String oldstr = "자바는 객체지향 언어 입니다.";
		
		String newstr = oldstr.replace("자바", "JAVA");
		
		System.out.println(oldstr);
		System.out.println(newstr);
		
		
		
		
	}

}
