package p2022_01_14;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Hwkeyboard {
//	키보드로 입력한 문장을 파일(result.txt)로 저장하는 
//  프로그램을 작성하세요?	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문장을 입력하세요?");
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			FileWriter fo = new FileWriter( "Home.txt" );
			String s =b.readLine();
			fo.write(s);
			fo.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
