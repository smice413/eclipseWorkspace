package p2022_01_11;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class EnumIterVector {
	
    public static void main( String[] args ) {
    	
	// Vector 객체 생성
	Vector v = new Vector( 1, 1 );
		
	// Vector에 Object 저장
//	add(Object e)
//	addElemnet(Object e) :Vector만 지원함
	v.add( 30 );
	v.addElement( new Integer( 10 ));
	v.addElement( "johnharu" );
	v.addElement( "gracedew" );
	
	System.out.println(v);
	
	for(int i = 0; i<v.size(); i++) {
		System.out.println(v.get(i)+"\t");
	}
	System.out.println();
	
	
	//나열형(Enumeration) : 30, 10, johnharu, gracedew
	// Vector의 Object의 나열형을 리턴
	Enumeration e = v.elements();
		
	// Enumeration을 이용해 Vector의 Object를 출력
	while( e.hasMoreElements() ) {	//가져올 데이터가 있으면 true
	    System.out.println( e.nextElement() );
	}
	
	//반복자(Iterator) : 30, 10, johnharu, gracedew
	// Vector의 Object의 나열형을 리턴
	Iterator ie = v.iterator();
		
	// Iterator을 이용해 Vector의 Object를 출력
	while( ie.hasNext() ) {
	    System.out.println( ie.next() );
	}	

    } //main end   
}
