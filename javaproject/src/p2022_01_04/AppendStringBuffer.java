package p2022_01_04;

public class AppendStringBuffer {
	public static void main(String[] args) {

		// StringBuffer 객체 생성
		StringBuffer sb1 = new StringBuffer("gemini");
		System.out.println("sb1 = " + sb1);

		// StringBuffer sb1에 문자열을 추가해 새로운 객체 생성
		StringBuffer sb2 = sb1.append(" is beautiful");
		System.out.println("sb2 = " + sb2);
		System.out.println("sb1 = " + sb1);//sb2와 같은 결과가 출력되는데 같은 주소를 쓰기 때문에 sb2에서 완성된 데이터를 그대로 가져오는 것.
		if(sb1 == sb2) {
			System.out.println("같은 주소");
		}else {
			System.out.println("다른 주소");
		}
		
		// 정수형 데이타 형을 추가
		System.out.println(sb1.append(1004));
		System.out.println("sb1 = " + sb1);
		System.out.println("sb2 = " + sb2);
									//StringBuffer는 toUpperCase가 없기 때문에 보통 부모한테 상속받는데 부모한테도 없기 때문에 String으로 변환해야함
		String str = new String(sb1); // StringBuffer를 String으로 변환 //String(StringBuffer buffer)메소드로 변환한것.
		System.out.println(str.toUpperCase()); //toUpperCase는 대문자로 바꿔주는것
	}
}
