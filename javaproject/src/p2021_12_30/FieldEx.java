package p2021_12_30;


//p202
class FieldInitValue{
	// 필드(field)
	byte byteField;					// 0 으로 초기화됨
	short shortField;
	int intField;
	long longField;
	
	float floatField;				// 0.0 으로 초기화됨
	double doubleField;
	
	char charField;
	boolean booleanField;			// false 로 초기화됨
	
	int[] arrField;					// null로 초기화 : 참조할 주소가 없다는 의미 
	String referenceField;			// null : 참조할 주소가 없다는 의미
}

public class FieldEx {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FieldInitValue f = new FieldInitValue();
		
		System.out.println("byteField:"+ f.byteField);
		System.out.println("shortField:"+ f.shortField);
		System.out.println("intField:"+ f.intField);
		System.out.println("longField:"+ f.longField);
		
		System.out.println("floatField:"+ f.floatField);
		System.out.println("doubleField:"+ f.doubleField);
		
		System.out.println("charField:"+ f.charField);
		System.out.println("booleanField:"+ f.booleanField);
		
		System.out.println("arrField:"+ f.arrField);
		System.out.println("referenceField:"+ f.referenceField);
	}

}
