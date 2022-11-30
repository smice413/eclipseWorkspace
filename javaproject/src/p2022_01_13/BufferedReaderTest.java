package p2022_01_13;

import java.io.*;

public class BufferedReaderTest {
    public static void main( String[] args ) {
		
	InputStream is = System.in;
	InputStreamReader isr = new InputStreamReader( is );
	BufferedReader br = new BufferedReader( isr );//한글 문자열을 입력받을 수 있다.띄어쓰기 해도 다 됨.
/*	//버퍼리더 생성자 객체를 만들려면 괄호안에 인풋스트림리더 생성자가 들어가야함.원래 최상위 클래스인 리더로 써져 있지만 업캐스팅으로 해서 자식클래스인 인풋스트림리더가 들어간것.
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
*/
	System.out.print( "Input Data : " );
		
	try {//readLine()메소드는 입력한 한줄을 모두읽음.
	    String inputString = br.readLine(); //readLine()은 예외처리 형식이 반드시 들어가야함. throws해도 되고 try catch해도 되고.
	    System.out.println();
	    System.out.println("Output String = " + inputString );	   
	} catch ( IOException io ) {
	    System.out.println( io.getMessage() );
	}
    }//main() end
}
