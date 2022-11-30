package p2022_01_05;

// p529
public class WrapperEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//박싱(bodxing)
		Integer obj01 = new Integer(10);
		Integer obj02 = new Integer("200");
		Integer obj03 = Integer.valueOf("300");
		
//언박싱(unboxing)
		int value1 = obj01.intValue();
		int value2 = obj02.intValue();   	//자료형 변환 : "200" --> 200
		int value3 = obj03;	// 오토언박싱		//자료형 변환 : "300" --> 300
		
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		
		
		
		
	}

}
