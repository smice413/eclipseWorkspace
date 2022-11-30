import a.b.Called;

public class Calling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Called c = new Called();// a.b.Called; import가 안되면 오류발생
		c.check();
	}

}

//1)  다른 패키지 안에 들어 있는 클래스에 접근 하기 위해서는 접근 제어제가
//    public 접근 제어자로 되어 있어야 한다.
//2)  다른 패키지 안에 들어 있는 클래스에 접근 하기 위해서는 해당 클래스를 import 를 
//    해야된다.


