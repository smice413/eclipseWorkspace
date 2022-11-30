package p2022_01_06;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameTestEx extends Frame {//extends를 써서 Frame 클래스를 상속받음

	public FrameTestEx() {

//	f = new Frame( "Frame Test" );
		super("Frame Test");	//"Frame Test"는 프레임 화면의 타이틀바에 표시됨	//super는 부모클래스를 호출하라는 의미 

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setSize(400, 300);
		setLocation(100, 100);
		setBackground(Color.green);
		setVisible(true);
	}// 생성자 end

	public static void main(String[] args) {
		FrameTestEx ft = new FrameTestEx();
	}
}