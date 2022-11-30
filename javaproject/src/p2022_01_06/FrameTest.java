package p2022_01_06;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameTest {

	private Frame f;				//필드

	public FrameTest() {			//생성자  //extends로 상속 안받고 직접 작성하여 상속 받음.
		f = new Frame("Frame Test");
		f.setSize(400, 300);		//프레임 크기 : 가로 400 세로 300 //setSize()메소드는 Frame 클래스에 있는것이 아닌 Window클래스에게 상속받은것
		f.setLocation(100, 100);   //프레임이 실행될 때 생겨나는 위치가 화면에서 왼쪽에서 100픽셀 위에서 부터 100픽셀에 위치//setLocation도 window상속받은것
		f.setBackground(Color.green);
		f.setVisible(true);
		f.setResizable(false);		//마우스로 화면을 끌어서 크게할 수 있냐는 true 못하게하면 false

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}// 생성자 end

	public static void main(String[] args) {
		FrameTest ft = new FrameTest();
	}
}