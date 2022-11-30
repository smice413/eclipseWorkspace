package p2022_01_11;

import java.util.Date;
import java.util.Stack;

public class StackTest {
    public static void main( String[] args ) {
    // Stack 객체 생성
	Stack s = new Stack();
	System.out.println( s.empty() );	//비어있으면 true
		
	// Stack에 값을 넣음
//	push(Object e)	
	s.push( "gemini" );
	 Date d = new Date();
	s.push( d );
	s.push( new Integer( 10 ));
	s.push( "johnharu" );

	// Stack의 값을 출력
	System.out.println( s.empty() );	//false
	System.out.println( s.peek() );		//.peek() 가장 마지막 데이터를 구해오는 역할 //johnharu
	System.out.println( s.pop() );		//pop() 가장 마지막 데이터를 출력하는 역할 //johnharu
	System.out.println( s.pop() );		//10
	System.out.println( s.pop() );		//Tue Jan 11 14:10:13 KST 2022
	System.out.println( s.pop() );		//gemini
	System.out.println( s.empty() );	//true	
    }	
}

