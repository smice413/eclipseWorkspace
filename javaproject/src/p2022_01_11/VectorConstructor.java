package p2022_01_11;

import java.util.Vector;

public class VectorConstructor {
    public static void main( String[] args ) {
    
        // 기본적인 vector 생성 방법
       Vector vector1 = new Vector();
       System.out.println("size1="+vector1.size() );
       System.out.println("capacity1="+vector1.capacity()); //capacity :공간의 크기가 얼마인가 구하는 메소드
        
        // 초기 capacity만 지정한 생성 방법
       Vector vector2 = new Vector( 3 );
       System.out.println("size2="+vector2.size());
       System.out.println("capacity2="+vector2.capacity());
        
        // vector에 값을 추가
        vector2.add( "gemini" );
        vector2.add( "johnharu" );
        vector2.add( "gracedew" );
        vector2.add( "bidon" );
       System.out.println("size2="+vector2.size());
       System.out.println("capacity2="+vector2.capacity());
        
        // 초기 capacity와 증가 capacity를 지정한 생성 방법
       Vector vector3 = new Vector( 1, 1 ); //Vector(처음 공간 크기, 공간의 크기가 부족할 경우 증가시킬 공간크기);
       vector3.add( "opendb" );
       System.out.println( "size3 = " + vector3.size() );
       System.out.println("capacity3="+vector3.capacity());
        
       vector3.add( "moon" );
       System.out.println( "size3 = " + vector3.size() );
	   System.out.println("capacity3="+vector3.capacity());
    }
}        
        
        
        