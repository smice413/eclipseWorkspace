package p2022_01_05;

public class WrapperEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Integer num = new Integer();		//오류 발생 : 기본생성자 지원X
											//박싱을 하는 이유는 기본 자료형을 객체화 하기위함 
		int n = 10;							//지역 변수(stack영역에 저장됨)
		Integer num01 = new Integer(n); 	//박싱(boxing):stack메모리에 저장된 지역 변수 10을 
											//            num01주소값 형성하여 heap메모리(박스)에 복사해서 저장하는 것.
		
											//언박싱(unboxing) : heap메모리에 있는 값을 stack메모리로 가져오는 것.
		int n01 = num01.intValue();			//				   intValue()메소드를 활용하여 num01의 heap메모리에 있는 데이터를 
											//				   stack메모리에 있는 지역변수 int n01로 가져와 저장하는 것.
		
		Integer num02 = new Integer("20");	//박싱(boxing)
		int n02 = num02.intValue(); 		//언박싱하는 과정에서 "20"---->20으로 자료형 변환함
		
		
	}

}
