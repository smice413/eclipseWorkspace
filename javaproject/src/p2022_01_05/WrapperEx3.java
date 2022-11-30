package p2022_01_05;


//p530
//자동 박싱과 자동 언박싱
public class WrapperEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//자동 박싱
		Integer ob = new Integer(100); 			         //박싱
		Integer obj = 100;  						     //자동 박싱 :new 연산자 없이 기본자료형 값을 바로 할당 해야함
		System.out.println("언박싱:"+ obj.intValue());     //언박싱
		System.out.println("자동 언박싱:"+ obj);			 //자동 언박싱
		
		//언박싱
		int value1 = obj.intValue();
		System.out.println(value1);
		
		//자동 언박싱
		int value2 = obj;
		System.out.println(value2);
		
		//자동 언박싱
		int result = obj + 100;				//int형으로 다시 변해서 100과 더해 200이 됨
		System.out.println("result"+result);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
