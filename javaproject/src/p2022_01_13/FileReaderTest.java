package p2022_01_13;

import java.io.FileReader;

public class FileReaderTest {
    public static void main( String[] args ) {
		
	// FileReader 객체 선언
	FileReader file = null;
	int inputValue = 0;
		
	try {
	    // "data.txt" File과 stream 형성
		//텍스트 파일을 불러오려면 같은 패키지에 있으면 안되고 javaproject최상위 폴더에다가 넣어야함
		file = new FileReader( "data.txt" );

	    // file의 끝을 만날 때까지 데이터를 읽어 들임
	    while(( inputValue = file.read() ) != -1 ) {
			System.out.print(( char )inputValue );
	    }


	    // stream을 닫음
//	    file.close();//그냥 닫아도 되지만 finally를 넣으면 오류발생 그래서 예외처리 또 넣어야함
	} catch ( Exception e ) {
	    System.out.println( e.toString() );
	}finally {
		if(file != null) //파일 자료가 있으면 true로 파일문을 잘 닫아라. 파일자료가 없다면 파일을 닫지말고 finally영향받아 강제종료만 안나게 해라.
			try { file.close();}catch(Exception e) {}
				
			
	}
    }//main() end
}
