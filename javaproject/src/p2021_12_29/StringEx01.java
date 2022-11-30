package p2021_12_29;

public class StringEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//교재 p148 예제
		
// String 객체
// == : 참조하는 주소를 비교		
// equals() : 참조하는 값(데이터)을 비교
		
		
		String str1 = "자바";
		String str2 = "자바";
		
		if(str1 == str2) { //비교 연산자(==)로 참조하는 주소를 비교
			System.out.println("같은 주소");
		}else {
			System.out.println("다른 주소");
		}
		
		String str3 = new String("자바");
		String str4 = new String("자바");
		
		if(str3 == str4) { //비교 연산자(==)로 참조하는 주소를 비교
			System.out.println("같은 주소");
		}else {
			System.out.println("다른 주소");
		}
		
		if(str1.equals(str2)) { //참조하는 값(데이터)을 비교
			System.out.println("참조하는 값이 같다.");
		}else {
			System.out.println("참조하는 값이 다르다.");
		}
		if(str3.equals(str4)) {  //참조하는 값(데이터)을 비교
			System.out.println("참조하는 값이 같다.");
		}else {
			System.out.println("참조하는 값이 다르다.");
		}
		if(str1.equals(str3)) {  //참조하는 값(데이터)을 비교
			System.out.println("참조하는 값이 같다.");
		}else {
			System.out.println("참조하는 값이 다르다.");
		}
		
		boolean b = "자바".equals("파이썬"); //같은 boolean형 데이터 이기 때문에 변수에 대입가능
		if(b) {
			System.out.println("같은 값");
		}else {
			System.out.println("다른 값");
		}
		
		if("오라클".equals("스프링")) {
			System.out.println("같은 값");
		}else {
			System.out.println("다른 값");
		}
		if(new Integer(30).equals(30)) {
			System.out.println("같은 값");
	    }else {
		System.out.println("다른 값");
	    }
		
		
	}

}
