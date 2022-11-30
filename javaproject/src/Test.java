import java.util.Date;

public     class Test {
//접근제어자              사용자 정의 클래스 첫글자 가능한 대문자로 먼저 작성해라
//                     메인 메소드 또는 함수라고 말함 메소드는 형식상 반드시 괄호를 가지고 있다
	                   //main 메소드는 자바가상머신(jvm)이 가장 먼저 호출하는 메소드이다.
	                   //메인 메소드가 없으면 컴파일만 가능하고 한개의 class가 독립적 실행 불가능
	public static void main(String[] args) {
	//접근제어자  공유                       []는 배열로 ()괄호 안에서 위치 이동가능 args는 이름 바꿔도 상관없음
		// TODO Auto-generated method stub
		System.out.println("자바 출력 성공");
        //System이나 String은 rt.jar라는 압축파일에 class형태로 들어가서 지원해주는 것. 이것은 class형태기 때문에 역컴파일을 해야 볼 수 있다.
        // jre의 class가 어떻게 만들어 지는지 확인하는 것이 api 문서 인데 '자바 api 8'로 검색해라
        // jre는 class를 묶어논 package
Date d= new Date();	}

}
//하나의 명령문을 완성하는게 1줄이고 큰 대괄호는 밑에 줄로 넘어가야함
//자료형의 문자는 ''을 넣고 클래스의 문자는""을 넣어야함
//자료형(첫 글자 소문자로 씀)은 변수라고 하고 클래스(첫글자 대문자 씀)는 객체라고 한다
//String의 S와 System의 S 대문자 중요 이 모두 JRE에서의 이름임
//이 것은 주석을 쓸때 사용
//자바의 주석기호 1.단일행 주석://
// 2. 다중행 주석:/*   */ 즉, 여러 줄을 주석으로 설정할 때 사용
//Eclipse 단축키: 중요한것
//실행: Ctrl+F11
//주석(단일행주석): Ctrl+/
//블럭 주석 처리(다중행주석): Ctrl+shift+/(해제는 \)
//한줄(블럭) 복사:Ctrl + Alt + Up(Down)
//한줄 삭제: Ctrl+D
//상태돌리기:Ctrl+Z
//이동:Alt+방향키
//자동으로 import 하기: Ctrl + Shift + O 
//*import는 java.lang에 있는 class는 별도로 안써도 되지만 lang에 없는 class는 import해야함
//정렬: Ctrl+shift+f
//명령어 자동 완성:Ctrl+스페이스바
//파일명 바꾸려면 마우스로 클릭하고 F2 누르면됨 (또는 마우스로 우클릭해서 refator-rename) 단, 소스상의 class 이름도 같이 바꿔야 오류안생김