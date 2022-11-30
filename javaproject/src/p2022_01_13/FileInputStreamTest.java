package p2022_01_13;

import java.io.*;

public class FileInputStreamTest {
    public static void main( String[] args ) {
    	
	// 입력을 받아들이는 변수 선언
	int inputValue = 0;
	
	// FileInputStream 객체 선언
	FileInputStream file = null;
		
	try {
	    // "read.txt"와 InputStream 형성//반드시 예외처리 해야함
		//텍스트 파일을 불러오려면 같은 패키지에 있으면 안되고 javaproject최상위 폴더에다가 넣어야함.최소한 상위 폴더에다 넣어야함.
		//    "../read.txt"  : 상위폴더에서 불러오라는 의미    "./read.txt"  : 현재폴더에서 불러오라는 의미  
	    file = new FileInputStream( "read.txt" );//상대경로로 읽어옴 
//	    file = new FileInputStream( "c:/read.txt" ); //절대경로로 읽어옴(파일명 경로명 순서를 다 써야함) 
	    
	    
	    
	    // file의 끝을 만날 때까지 데이터를 읽어 들임
		// read() 메소드는 File에서 한 byte씩 데이터를 읽어옴.
		// 읽어온 데이터를 int로 변환해서 리턴,파일의 끝을 
		// 만나면 -1을 반환함.
	    while(( inputValue = file.read() ) != -1 ) { //inputValue에 아스키 코드로 저장되었다가 출력할때 캐릭터형으로 변환해서 글을 출력
			System.out.print(( char )inputValue );//한글자씩 출력되기 때문에 루프를 돌림 .
        //글자가 다 출력되면 -1을 리턴하면서 읽어올 값이 없다고 인식함.따라서 -1과 같지 않다라는 조건문으로 false가 되어 반복문 끝남.
	    }
	} catch ( Exception e ) {
	    System.out.println( e.toString() );
	    
	}finally {
		if(file != null) {
			try{file.close();}catch(Exception e) {}
		}
	}

	// stream을 형성한 file을 닫음
//	try {
//	    file.close();
//	} catch ( IOException io ) {
//	    System.out.println( io.toString() );
//	}
    }//main() end
}
