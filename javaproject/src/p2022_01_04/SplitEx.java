package p2022_01_04;

public class SplitEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//파싱하는 방법: split("구분기호")->String[] 배열로 0번 방부터 저장됨
		String jumin = "900101-1234567";
		String[] j = jumin.split("-"); //String형인 "-"을 기준으로 주민번호 앞자리는 0번방, 뒷자리는 1번 방에 저장됨
		
		System.out.println("주민번호 앞자리:"+j[0]);
		System.out.println("주민번호 뒷자리:"+j[1]);
		
		for(int i = 0; i<j.length;i++) 
			System.out.println(j[i]);
		
		for(String s : j)//확장 for문
			System.out.println(s);
		
		String tel = "010-1234-5678";
		String[] t = tel.split("-");
		System.out.println("전화번호 앞자리:"+t[0]);
		System.out.println("전화번호 중간자리:"+t[1]);
		System.out.println("전화번호 끝자리:"+t[2]);
		
		String email = "totoro@naver.com";
		String[] e = email.split("@");
		System.out.println("아이디:"+e[0]);
		System.out.println("도메인:"+e[1]);
		
		
		
		
				
		
		
	}

}
