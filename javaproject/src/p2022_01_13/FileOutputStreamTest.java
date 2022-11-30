package p2022_01_13;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamTest {
    public static void main( String[] args ) {
    	
	try {
		// * 첫째 인수로 지정된 파일 객체에서 읽어서 
		// 둘째 인수로 지정된 파일 객체에 출력함
		// (즉, 동일한 파일이 생성됨)
	    // File에서 데이터를 읽어오는 FileInputStream 객체 생성	    
	    FileInputStream fis = new FileInputStream("read.txt"); //1byte데이터만 가능

	    // File에 데이터를 전송하기 위한 FileOutputStream 객체 생성	   
	    FileOutputStream fos = new FileOutputStream( "read1.txt" );  //상대경로로 저장될 곳 
	    //read.txt파일에서 읽어와서 복사본 파일 read1.txt파일 생성함. 상대경로기 때문에 javaproject폴더에 생성됨
	    
//	    FileOutputStream fos = new FileOutputStream( "c:/Temp/read1.txt" ); //절대경로로 저장될 곳
	    //C드라이브 Temp폴더에 rea1.txt파일이 생성됨.
	    int input = 0;		
		
	    // File에 저장된 모든 데이터를 스트림을 통해 
		// 읽어 들여 File에 저장
		// 파일의 내용을 끝까지 다 읽으면 -1이 반환됨.
	    while(( input = fis.read() ) != -1 ) {
			System.out.print( (char)input ); //화면에 출력 부분
			fos.write( input ); // write()메소드로 다른 파일에 쓰는 부분//input의 유니코드값이 자동형변환되어 저장됨.
	    }

	    // FileInputStream, FileOutputStream을 해제	   
	    fos.close();
	    fis.close();
	    
	} catch( Exception e ) {
	    System.out.println( e.getMessage() );	    
	}
    }//main() end
}
