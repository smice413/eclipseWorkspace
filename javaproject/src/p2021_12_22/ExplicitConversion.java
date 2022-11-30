package p2021_12_22;

public class ExplicitConversion {

    public static void main( String[] args ) {
    	
	// int형 변수를 97로 초기화
	int intValue = 97;
	
	// char형 변수에 int형 변수 값을 할당
	char charValue = (char)intValue;//강제 형변환
	System.out.println( "charValue = " + charValue );

	// float형 변수 초기화.
	float floatValue = 3.14F;
	
	// int형 변수에 float형 변수 값을 할당
	int intValue2 = (int)floatValue;
	System.out.println( "intValue2 = " + intValue2 );

	// float형 변수 초기화
	double doubleValue = 21.12345678901234567890;
	//소수점 자리값의 한계가 있다. 더 작은 값을 버림 그래서 double형을 많이 슴
	
	// float형 변수에 double형 변수 값을 할당
	float floatValue2 = (float)doubleValue;
	System.out.println( "floatValue3 = " + floatValue2 );

    }
}