package p2021_12_22;

public class Oper04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 비교 연산자: >, <, >=, <=, ==(같다), !=(같지않다)
		// 비교 연산자의 결과가 참이면 true, 거짓이면 false 값을 리턴(왼쪽에 있는 변수에게 돌려준다)한다.
//String만 유일하게 new연산자와 없는 것을 모두 쓸 수 있다.
		String str1 = "자바";
		String str2 = "자바";
		String str3 = new String("자바");

		// str1과 str2 는 같은 주소값으로 같은 "자바"와 연결, str3는 new 연산자를 붙이면서 다른 주소값의 "자바"와 연결
		if (str1 == str2) {
			System.out.println("같은 주소");
		} else {
			System.out.println("다른 주소");
		}
		if (str1 == str3) {
			System.out.println("같은 주소");
		} else {
			System.out.println("다른 주소");
		}
		// 위는 자료형과 달리 참조형으로 비교연산자는 주소를 비교하는데, 데이터 값을 비교하려면 equals를 써야함. 즉 데이터값(문자가 다르면)다르면 false뜸
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));

	}

}
