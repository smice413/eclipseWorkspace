package p2022_01_11;

import java.util.*;

public class StoredVector {
    public static void main( String[] args ) {
    
        // Vector 객체 생성
        Vector v = new Vector( 1, 1 );
        
        // Vector에 객체 저장
        v.add( "gemini" );
        v.addElement( new Integer(10) );
        v.addElement( "johnharu" );
        v.addElement( "gracedew" );

		System.out.println(v);
        
        // Vector에 저장된 객체의 개수를 구함
        int length = v.size();
        
        // 처음부터 순차적으로 객체를 꺼냄
        for ( int i=0; i<length; i++ ) {
            System.out.println( v.get(i) );
        }
        
        System.out.println( v.firstElement() );	//firstElement: 첫번째 원소를 구해와라.
        System.out.println( v.indexOf( "johnharu" ) );//indexof():값의 인덱스 번호 구해라
        System.out.println( v.isEmpty() );//isEmpty:비어있으면 true값을 리턴해서 출력하지만 값이 다 차있으므로 false여서 출력X
        
        // 인덱스가 2인 객체를 삭제
        v.remove( 2 );
        System.out.println( v.elementAt( 2 ));//2번 방의 원소를 구해와라
        
        //인덱스가 2인 객체 값을 "park"로 설정
        v.set( 2, "park" );//2번방 원소값을 park로 수정해라
        System.out.println( v );
    }
}
        
        
             
        